package com.passengerdb.mmnhutils.fixes;

public class ModCheck {

    private ModCheck() {}

    private static boolean chromaticraft = false;
    private static boolean dragonapi = false;

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

}
