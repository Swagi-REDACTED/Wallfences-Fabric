package net.wallfence.init;

import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.wallfence.WallfenceMod;
import net.wallfence.block.*;

public class WallfenceModBlocks {
   public static final Block TINTED_GLASS_PANE = register("tinted_glass_pane", TintedGlassPaneBlock::new);
   public static final Block SMOOTH_STONE_STAIRS = register("smooth_stone_stairs", SmoothStoneStairsBlock::new);
   public static final Block SMOOTH_STONE_WALL = register("smooth_stone_wall", SmoothStoneWallBlock::new);
   public static final Block POLISHED_ANDESITE_WALL = register("polished_andesite_wall", PolishedAndesiteWallBlock::new);
   public static final Block POLISHED_DIORITE_WALL = register("polished_diorite_wall", PolishedDioriteWallBlock::new);
   public static final Block POLISHED_GRANITE_WALL = register("polished_granite_wall", PolishedGraniteWallBlock::new);
   public static final Block CALCITE_STAIRS = register("calcite_stairs", CalciteStairsBlock::new);
   public static final Block CALCITE_SLAB = register("calcite_slab", CalciteSlabBlock::new);
   public static final Block CALCITE_WALL = register("calcite_wall", CalciteWallBlock::new);
   public static final Block POLISHED_CALCITE = register("polished_calcite", PolishedCalciteBlock::new);
   public static final Block POLISHED_CALCITE_STAIRS = register("polished_calcite_stairs", PolishedCalciteStairsBlock::new);
   public static final Block POLISHED_CALCITE_SLAB = register("polished_calcite_slab", PolishedCalciteSlabBlock::new);
   public static final Block POLISHED_CALCITE_WALL = register("polished_calcite_wall", PolishedCalciteWallBlock::new);
   public static final Block STONE_WALL = register("stone_wall", StoneWallBlock::new);
   public static final Block QUARTZ_WALL = register("quartz_wall", QuartzWallBlock::new);
   public static final Block SMOOTH_QUARTZ_WALL = register("smooth_quartz_wall", SmoothQuartzWallBlock::new);

   private static <B extends Block> B register(String name, Function<Properties, B> supplier) {
      Identifier id = Identifier.fromNamespaceAndPath(WallfenceMod.MODID, name);
      ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, id);
      return Registry.register(BuiltInRegistries.BLOCK, id, supplier.apply(Properties.of().setId(key)));
   }
   
   public static void register() {
       // Class loading triggers the static initializers.
   }
}
