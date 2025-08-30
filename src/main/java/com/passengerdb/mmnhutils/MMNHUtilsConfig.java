package com.passengerdb.mmnhutils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config(modid = DragonFix.MODID)
public class MMNHUtilsConfig {

	private MMNHUtilsConfig() {
	}

	@Config.Comment(value = { "Extra blacklist entity parent full class names for ChromatiCraft spawner reprogrammer",
			"If an entity \"is a\" type of one of the follow classes, it won't be set in spawner reprogrammer",
			"For example, \"net.minecraft.entity.boss.IBossDisplayData\", then all bosses can't be set for spawner in spawner reprogrammer" })
	@Config.DefaultStringList(value = { "net.minecraft.entity.boss.IBossDisplayData" })
	private static String[] spawnerReprogrammerBlacklistEntityParent;

	public static List<String> getSpawnerReprogrammerBlacklistEntityParent() {
		return Collections.unmodifiableList(Arrays.asList(spawnerReprogrammerBlacklistEntityParent));
	}

}
