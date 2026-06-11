package net.wallfence.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class QuartzWallBlock extends WallBlock {
   public QuartzWallBlock(Properties properties) {
      super(
         properties.sound(SoundType.STONE)
            .strength(2.0F, 5.0F)
            .requiresCorrectToolForDrops()
            .noOcclusion()
            .isRedstoneConductor((bs, br, bp) -> false)
            .forceSolidOn()
      );
   }

   public int getLightBlock(BlockState state) {
      return 0;
   }
}
