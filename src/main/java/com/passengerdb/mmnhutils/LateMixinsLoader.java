package com.passengerdb.mmnhutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;
import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class LateMixinsLoader implements ILateMixinLoader {

    static {
        try {
            ConfigurationManager.registerConfig(MMNHUtilsConfig.class);
            MMNHUtils.LOG.info("Config initialized.");
        } catch (Exception e) {
            MMNHUtils.LOG.error("Unable to register config. All settings keep default value.", e);
        }
    }

    @Override
    public String getMixinConfig() {
        return "mixins.mmnhutils.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {

        List<String> mixins = new ArrayList<>();

        if (loadedMods.contains("DragonAPI")) {
            processDAPIMixins(mixins);
        }
        if (loadedMods.contains("ChromatiCraft")) {
            processCCMixins(mixins);
        }
        if (loadedMods.contains("manametalmod")) {
            ModCheck.manametalmodLoad();
        }
        if (loadedMods.contains("MineTweaker3")) {
            ModCheck.minetweaker3Load();
        }
        if (loadedMods.contains("mo")) {
            processMOMixins(mixins);
        }
        if (loadedMods.contains("RotaryCraft")) {
            processROCMixins(mixins);
        }

        return mixins;
    }

    private static void processDAPIMixins(List<String> mixins) {
        ModCheck.dapiLoad();
        if (MMNHUtilsConfig.isEnableDamageArmorItemFix()) mixins.add("dragonapi.DamageArmorItemMixin");
    }

    private static void processCCMixins(List<String> mixins) {
        ModCheck.ccLoad();
        if (MMNHUtilsConfig.isEnableStructureBypassKeyCalculationFix())
            mixins.add("chromaticraft.StructurePasswordCheckPasswordMixin");
        if (MMNHUtilsConfig.isChangeItemCollectorCollectItemFromEventBehavior())
            mixins.add("chromaticraft.TileEntityItemCollectorEventMixin");
        if (MMNHUtilsConfig.isDisableItemMoverInteractWithISidedInventory())
            mixins.add("chromaticraft.ItemBulkMoverMixin");
        mixins.add("chromaticraft.TileEntitySpawnerReprogrammerMixin");
        if (MMNHUtilsConfig.isEnableShiftMazeBypassCrashFix()) mixins.add("chromaticraft.ShiftMazeGeneratorMixin");
    }

    private static void processMOMixins(List<String> mixins) {
        ModCheck.matteroverdriveLoad();
        if (MMNHUtilsConfig.isEnableMOAndroidNameFix()) mixins.add("matteroverdrive.EntityRougeAndroidMobMixin");
    }

    private static void processROCMixins(List<String> mixins) {
        ModCheck.rotarycraftLoad();
        if (MMNHUtilsConfig.isEnableGearboxDisassembleFix()) mixins.add("rotarycraft.TileEntityWorktableMixin");
    }

}
