package com.passengerdb.mmnhutils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.gtnewhorizon.gtnhlib.config.Config;

@Config(modid = MMNHUtils.MODID)
public class MMNHUtilsConfig {

    private MMNHUtilsConfig() {}

    @Config.Comment(
        value = { "Extra blacklist entity parent full class names for ChromatiCraft spawner reprogrammer",
            "If an entity \"is a\" type of one of the follow classes, it won't be set in spawner reprogrammer",
            "For example, \"net.minecraft.entity.boss.IBossDisplayData\", then all bosses can't be set for spawner in spawner reprogrammer" })
    @Config.DefaultStringList(value = { "net.minecraft.entity.boss.IBossDisplayData" })
    private static String[] spawnerReprogrammerBlacklistEntityParent;

    @Config.Comment("Whether or not to enable proxima structure bypass key calculation fix")
    @Config.DefaultBoolean(value = true)
    private static boolean enableStructureBypassKeyCalculationFix;

    @Config.Comment("Whether or not to enable fixing Reika's damage armor method, prevent it to destroy some unbreakable armors")
    @Config.DefaultBoolean(value = true)
    private static boolean enableDamageArmorItemFix;

    @Config.Comment("Whether or not to disable M3 dungeon mob appears in non dungeon dimensions")
    @Config.DefaultBoolean(value = true)
    private static boolean disableM3DungeonMobAppearsInNonDungeonDimension;

    @Config.Comment("Disable ChromatiCraft's item collector collect item from EntityJoinWorldEvent. May cause collector to work slower but can prevent item duplication bug.")
    @Config.DefaultBoolean(value = true)
    private static boolean disableItemCollectorCollectItemFromEvent;

    @Config.Comment("Disable ChromatiCraft's item mover interact with ISidedInventory container.")
    @Config.DefaultBoolean(value = true)
    private static boolean disableItemMoverInteractWithISidedInventory;

    @Config.Comment("Whether or not to enable fix of server crash when using bypass panel of shifting maze")
    @Config.DefaultBoolean(value = true)
    private static boolean enableShiftMazeBypassCrashFix;

    @Config.Comment(
        value = { "Whether or not to try to reload minetweaker script (at most 3 times) on server started",
            "This is used to try to fix hashing issue in Thermal Expansion recipes" })
    @Config.DefaultBoolean(value = true)
    private static boolean tryReloadMTScriptOnServerStarted;

    public static List<String> getSpawnerReprogrammerBlacklistEntityParent() {
        return Collections.unmodifiableList(Arrays.asList(spawnerReprogrammerBlacklistEntityParent));
    }

    public static boolean isEnableStructureBypassKeyCalculationFix() {
        return enableStructureBypassKeyCalculationFix;
    }

    public static boolean isEnableDamageArmorItemFix() {
        return enableDamageArmorItemFix;
    }

    public static boolean isDisableM3DungeonMobAppearsInNonDungeonDimension() {
        return disableM3DungeonMobAppearsInNonDungeonDimension;
    }

    public static boolean isDisableItemCollectorCollectItemFromEvent() {
        return disableItemCollectorCollectItemFromEvent;
    }

    public static boolean isDisableItemMoverInteractWithISidedInventory() {
        return disableItemMoverInteractWithISidedInventory;
    }

    public static boolean isEnableShiftMazeBypassCrashFix() {
        return enableShiftMazeBypassCrashFix;
    }

    public static boolean isTryReloadMTScriptOnServerStarted() {
        return tryReloadMTScriptOnServerStarted;
    }

}
