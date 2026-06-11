package net.wallfence.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PolishedCalciteBlock extends Block {
   public PolishedCalciteBlock(Properties properties) {
      super(properties.instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).strength(1.0F, 5.0F).requiresCorrectToolForDrops());
   }

   public boolean propagatesSkylightDown(BlockState state) {
      return true;
   }

   public int getLightBlock(BlockState state) {
      return 0;
   }
}
