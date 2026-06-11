package net.wallfence.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SmoothQuartzWallBlock extends WallBlock {
   public SmoothQuartzWallBlock(Properties properties) {
      super(properties.sound(SoundType.STONE).strength(2.0F, 5.0F).requiresCorrectToolForDrops().forceSolidOn());
   }
}
