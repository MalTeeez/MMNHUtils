package com.passengerdb.mmnhutils;

public class ModCheck {

    private ModCheck() {}

    private static boolean chromaticraft = false;
    private static boolean dragonapi = false;
    private static boolean manametalmod = false;

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

}
