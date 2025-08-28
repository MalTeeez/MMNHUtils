package com.passengerdb.dragonfix;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MyMod.MODID, version = Tags.VERSION, name = "DragonFix", acceptedMinecraftVersions = "[1.7.10]")
public class MyMod {

	public static final String MODID = "dragonfix";
	public static final Logger LOG = LogManager.getLogger(MODID);

	@Mod.EventHandler
	// preInit "Run before anything else. Read your config, create blocks, items,
	// etc, and register them with the
	// GameRegistry." (Remove if not needed)
	public void preInit(FMLPreInitializationEvent event) {
		// TODO init config
	}

	@Mod.EventHandler
	// postInit "Handle interaction with other mods, complete your setup based on
	// this." (Remove if not needed)
	public void postInit(FMLPostInitializationEvent event) {
		// TODO: modify spawner reprogrammer blacklist
	}

}
