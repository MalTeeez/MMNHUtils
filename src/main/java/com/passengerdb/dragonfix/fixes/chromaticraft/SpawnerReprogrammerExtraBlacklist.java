package com.passengerdb.dragonfix.fixes.chromaticraft;

import com.passengerdb.dragonfix.DragonFix;

public class SpawnerReprogrammerExtraBlacklist {
	
	private SpawnerReprogrammerExtraBlacklist() {}

	
	
	public static void init() {
		try {
			Class<?> spawnerRepoCls = Class.forName("Reika.ChromatiCraft.TileEntity.Processing.TileEntitySpawnerReprogrammer");
		}catch (ClassNotFoundException e) {
			DragonFix.LOG.info("ChromatiCraft not installed");
		}
	}
	
}
