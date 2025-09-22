package com.passengerdb.mmnhutils.fixes.minetweaker3;

import com.passengerdb.mmnhutils.MMNHUtils;

import minetweaker.MineTweakerImplementationAPI;

public class MinetweakerUtils {

    private MinetweakerUtils() {}

    public static void reloadMTRecipe(int times) {
        for (int i = 1; i <= times; i++) {
            MMNHUtils.LOG.info("Try to reload minetweaker recipe {} time.", Integer.valueOf(i));
            if (tryReloadMTRecipe()) {
                MMNHUtils.LOG.info("Minetweaker recipe reload successful.");
                return;
            }
        }
        MMNHUtils.LOG
            .info("Fail to reload minetweaker recipe in {} times. Stop trying reloading.", Integer.valueOf(times));
    }

    private static boolean tryReloadMTRecipe() {
        try {
            MineTweakerImplementationAPI.reload();
            return true;
        } catch (Exception e) {
            MMNHUtils.LOG.error("Exception caugth while trying to reload minetweaker recipe:", e);
            return false;
        }
    }

}
