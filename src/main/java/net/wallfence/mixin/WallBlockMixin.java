package net.wallfence.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WallBlock.class)
public abstract class WallBlockMixin {

    @Shadow
    protected abstract boolean shouldRaisePost(BlockState state, BlockState topNeighbour, VoxelShape aboveShape);

    @Inject(method = "updateShape(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/world/level/ScheduledTickAccess;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/util/RandomSource;)Lnet/minecraft/world/level/block/state/BlockState;", at = @At("RETURN"), cancellable = true)
    private void wallfence$onUpdateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random, CallbackInfoReturnable<BlockState> cir) {
        BlockState result = cir.getReturnValue();
        if (result == null) return;
        
        boolean changed = false;

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            BlockState neighbor = level.getBlockState(pos.relative(dir));
            if (neighbor.is(BlockTags.FENCES)) {
                Property<WallSide> property = WallBlock.PROPERTY_BY_DIRECTION.get(dir);
                if (result.getValue(property) == WallSide.LOW || result.getValue(property) == WallSide.NONE) {
                    result = result.setValue(property, WallSide.TALL);
                    changed = true;
                }
            }
        }

        if (changed) {
            BlockPos above = pos.above();
            BlockState aboveState = level.getBlockState(above);
            VoxelShape aboveShape = aboveState.getCollisionShape(level, above).getFaceShape(Direction.DOWN);
            
            result = result.setValue(WallBlock.UP, this.shouldRaisePost(result, aboveState, aboveShape));
            cir.setReturnValue(result);
        }
    }

    @Inject(method = "getStateForPlacement", at = @At("RETURN"), cancellable = true)
    private void wallfence$onGetStateForPlacement(BlockPlaceContext context, CallbackInfoReturnable<BlockState> cir) {
        BlockState result = cir.getReturnValue();
        if (result == null) return;

        LevelReader level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        boolean changed = false;

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            BlockState neighbor = level.getBlockState(pos.relative(dir));
            if (neighbor.is(BlockTags.FENCES)) {
                Property<WallSide> property = WallBlock.PROPERTY_BY_DIRECTION.get(dir);
                if (result.getValue(property) == WallSide.LOW || result.getValue(property) == WallSide.NONE) {
                    result = result.setValue(property, WallSide.TALL);
                    changed = true;
                }
            }
        }

        if (changed) {
            BlockPos above = pos.above();
            BlockState aboveState = level.getBlockState(above);
            VoxelShape aboveShape = aboveState.getCollisionShape(level, above).getFaceShape(Direction.DOWN);
            
            result = result.setValue(WallBlock.UP, this.shouldRaisePost(result, aboveState, aboveShape));
            cir.setReturnValue(result);
        }
    }
}
