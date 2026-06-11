package net.wallfence.block;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PolishedCalciteSlabBlock extends SlabBlock {
   public PolishedCalciteSlabBlock(Properties properties) {
      super(properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).strength(1.0F, 5.0F).requiresCorrectToolForDrops());
   }

   public int getLightBlock(BlockState state) {
      return 0;
   }
}
