package net.wallfence.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class SmoothStoneWallBlock extends WallBlock {
   public SmoothStoneWallBlock(Properties properties) {
      super(properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(2.0F, 5.0F).requiresCorrectToolForDrops().forceSolidOn());
   }

   public int getLightBlock(BlockState state) {
      return 0;
   }
}
