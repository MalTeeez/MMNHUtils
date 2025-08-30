package com.passengerdb.mmnhutils.fixes.chromaticraft;

import java.lang.reflect.Field;
import java.util.HashSet;

import com.passengerdb.mmnhutils.MMNHUtils;
import com.passengerdb.mmnhutils.MMNHUtilsConfig;

import Reika.ChromatiCraft.TileEntity.Processing.TileEntitySpawnerReprogrammer;

public class SpawnerReprogrammerExtraBlacklist {

    private SpawnerReprogrammerExtraBlacklist() {}

    public static void init() {

        try {
            @SuppressWarnings("unchecked")
            Class<TileEntitySpawnerReprogrammer> spawnerRepoCls = (Class<TileEntitySpawnerReprogrammer>) Class
                .forName("Reika.ChromatiCraft.TileEntity.Processing.TileEntitySpawnerReprogrammer");

            addBlackListParents(spawnerRepoCls);

        } catch (Exception e) {
            MMNHUtils.LOG.error("Unable to init SpawnerReprogrammerExtraBlacklist", e);
        }
    }

    @SuppressWarnings("unchecked")
    private static void addBlackListParents(Class<TileEntitySpawnerReprogrammer> spawnerRepoCls)
        throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Field disallowParentField = spawnerRepoCls.getDeclaredField("disallowedMobParents");
        disallowParentField.setAccessible(true);
        HashSet<Class<?>> disallowedMobParents = (HashSet<Class<?>>) disallowParentField.get(null);

        MMNHUtilsConfig.getSpawnerReprogrammerBlacklistEntityParent()
            .forEach(p -> addBlackListParent(disallowedMobParents, p));

        MMNHUtils.LOG.info("disallowedMobParents now contains: {}", disallowedMobParents);
    }

    private static void addBlackListParent(HashSet<Class<?>> disallowed, String className) {
        try {
            Class<?> toAdd = Class.forName(className);
            disallowed.add(toAdd);
        } catch (ClassNotFoundException e) {
            MMNHUtils.LOG.warn("Unable to find entity class: {}", className);
        }
    }

}
