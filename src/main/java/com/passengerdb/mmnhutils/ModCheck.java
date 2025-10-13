package com.passengerdb.mmnhutils;

public class ModCheck {

    private ModCheck() {}

    private static boolean chromaticraft = false;
    private static boolean dragonapi = false;
    private static boolean manametalmod = false;
    private static boolean minetweaker3 = false;
    private static boolean matteroverdrive = false;
    private static boolean rotarycraft = false;

    public static void ccLoad() {
        chromaticraft = true;
    }

    public static boolean isCcLoaded() {
        return chromaticraft;
    }

    public static void dapiLoad() {
        dragonapi = true;
    }

    public static boolean isDapiLoaded() {
        return dragonapi;
    }

    public static void manametalmodLoad() {
        manametalmod = true;
    }

    public static boolean isManametalmodLoaded() {
        return manametalmod;
    }

    public static void minetweaker3Load() {
        minetweaker3 = true;
    }

    public static boolean isMinetweaker3Loaded() {
        return minetweaker3;
    }

    public static void matteroverdriveLoad() {
        matteroverdrive = true;
    }

    public static boolean isMatteroverdriveLoaded() {
        return matteroverdrive;
    }

    public static void rotarycraftLoad() {
        rotarycraft = true;
    }

    public static boolean isRotarycraftLoaded() {
        return rotarycraft;
    }

}
