package net.wallfence.init;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class WallfenceModTabs {

    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> {
            content.accept(WallfenceModItems.TINTED_GLASS_PANE);
            content.accept(WallfenceModItems.POLISHED_CALCITE);
            content.accept(WallfenceModItems.SMOOTH_STONE_STAIRS);
            content.accept(WallfenceModItems.CALCITE_STAIRS);
            content.accept(WallfenceModItems.POLISHED_CALCITE_STAIRS);
            content.accept(WallfenceModItems.CALCITE_SLAB);
            content.accept(WallfenceModItems.POLISHED_CALCITE_SLAB);
            content.accept(WallfenceModItems.POLISHED_ANDESITE_WALL);
            content.accept(WallfenceModItems.POLISHED_DIORITE_WALL);
            content.accept(WallfenceModItems.POLISHED_GRANITE_WALL);
            content.accept(WallfenceModItems.STONE_WALL);
            content.accept(WallfenceModItems.SMOOTH_STONE_WALL);
            content.accept(WallfenceModItems.CALCITE_WALL);
            content.accept(WallfenceModItems.POLISHED_CALCITE_WALL);
            content.accept(WallfenceModItems.QUARTZ_WALL);
            content.accept(WallfenceModItems.SMOOTH_QUARTZ_WALL);
        });
    }
}
