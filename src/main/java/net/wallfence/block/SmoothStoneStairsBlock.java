package net.wallfence.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class SmoothStoneStairsBlock extends StairBlock {
   public SmoothStoneStairsBlock(Properties properties) {
      super(
         Blocks.AIR.defaultBlockState(),
         properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(2.0F, 5.0F).requiresCorrectToolForDrops()
      );
   }

   public float getExplosionResistance() {
      return 5.0F;
   }

   public int getLightBlock(BlockState state) {
      return 0;
   }
}
