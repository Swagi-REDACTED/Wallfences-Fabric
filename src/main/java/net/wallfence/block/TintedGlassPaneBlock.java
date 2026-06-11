package net.wallfence.block;

import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class TintedGlassPaneBlock extends IronBarsBlock {
   public TintedGlassPaneBlock(Properties properties) {
      super(
         properties.instrument(NoteBlockInstrument.BASEDRUM)
            .sound(SoundType.GLASS)
            .strength(0.5F, 2.0F)
            .noOcclusion()
            .isRedstoneConductor((bs, br, bp) -> false)
      );
   }
}
