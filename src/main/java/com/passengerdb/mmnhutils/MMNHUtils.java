package com.passengerdb.mmnhutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;
import com.passengerdb.mmnhutils.fixes.ModCheck;
import com.passengerdb.mmnhutils.fixes.chromaticraft.SpawnerReprogrammerExtraBlacklist;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(
    modid = MMNHUtils.MODID,
    version = Tags.VERSION,
    name = "MMNHUtils",
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "required-after:gtnhlib@[0.6.33,);")
public class MMNHUtils {

    public static final String MODID = "mmnhutils";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items,
    // etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) throws ConfigException {
        ConfigurationManager.registerConfig(MMNHUtilsConfig.class);
        LOG.info("Config initialized.");
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on
    // this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        if (ModCheck.isCcLoaded()) {
            SpawnerReprogrammerExtraBlacklist.init();
        }
    }

}
