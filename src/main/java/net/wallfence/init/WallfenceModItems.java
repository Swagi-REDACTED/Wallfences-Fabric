package net.wallfence.init;

import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.wallfence.WallfenceMod;

public class WallfenceModItems {
   public static final Item TINTED_GLASS_PANE = block("tinted_glass_pane", WallfenceModBlocks.TINTED_GLASS_PANE);
   public static final Item SMOOTH_STONE_STAIRS = block("smooth_stone_stairs", WallfenceModBlocks.SMOOTH_STONE_STAIRS);
   public static final Item SMOOTH_STONE_WALL = block("smooth_stone_wall", WallfenceModBlocks.SMOOTH_STONE_WALL);
   public static final Item POLISHED_ANDESITE_WALL = block("polished_andesite_wall", WallfenceModBlocks.POLISHED_ANDESITE_WALL);
   public static final Item POLISHED_DIORITE_WALL = block("polished_diorite_wall", WallfenceModBlocks.POLISHED_DIORITE_WALL);
   public static final Item POLISHED_GRANITE_WALL = block("polished_granite_wall", WallfenceModBlocks.POLISHED_GRANITE_WALL);
   public static final Item CALCITE_STAIRS = block("calcite_stairs", WallfenceModBlocks.CALCITE_STAIRS);
   public static final Item CALCITE_SLAB = block("calcite_slab", WallfenceModBlocks.CALCITE_SLAB);
   public static final Item CALCITE_WALL = block("calcite_wall", WallfenceModBlocks.CALCITE_WALL);
   public static final Item POLISHED_CALCITE = block("polished_calcite", WallfenceModBlocks.POLISHED_CALCITE);
   public static final Item POLISHED_CALCITE_STAIRS = block("polished_calcite_stairs", WallfenceModBlocks.POLISHED_CALCITE_STAIRS);
   public static final Item POLISHED_CALCITE_SLAB = block("polished_calcite_slab", WallfenceModBlocks.POLISHED_CALCITE_SLAB);
   public static final Item POLISHED_CALCITE_WALL = block("polished_calcite_wall", WallfenceModBlocks.POLISHED_CALCITE_WALL);
   public static final Item STONE_WALL = block("stone_wall", WallfenceModBlocks.STONE_WALL);
   public static final Item QUARTZ_WALL = block("quartz_wall", WallfenceModBlocks.QUARTZ_WALL);
   public static final Item SMOOTH_QUARTZ_WALL = block("smooth_quartz_wall", WallfenceModBlocks.SMOOTH_QUARTZ_WALL);

   private static <I extends Item> I register(String name, Function<Item.Properties, I> supplier) {
      Identifier id = Identifier.fromNamespaceAndPath(WallfenceMod.MODID, name);
      ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
      return Registry.register(BuiltInRegistries.ITEM, id, supplier.apply(new Item.Properties().setId(key)));
   }

   private static Item block(String name, Block block) {
      Identifier id = Identifier.fromNamespaceAndPath(WallfenceMod.MODID, name);
      ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
      return Registry.register(BuiltInRegistries.ITEM, id, new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(key)));
   }

   public static void register() {
       // Class loading triggers static initializers
   }
}
