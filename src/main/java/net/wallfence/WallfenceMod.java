package net.wallfence;

import net.fabricmc.api.ModInitializer;
import net.wallfence.init.WallfenceModBlocks;
import net.wallfence.init.WallfenceModItems;
import net.wallfence.init.WallfenceModTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WallfenceMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(WallfenceMod.class);
    public static final String MODID = "wallfence";

    @Override
    public void onInitialize() {
        WallfenceModBlocks.register();
        WallfenceModItems.register();
        WallfenceModTabs.register();
        LOGGER.info("Wallfence initialized!");
    }
}
