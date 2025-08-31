package com.passengerdb.mmnhutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class LateMixinsLoader implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.mmnhutils.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {

        List<String> mixins = new ArrayList<>();

        if (loadedMods.contains("DragonAPI")) {
            ModCheck.dapiLoad();
            mixins.add("dragonapi.DamageArmorItemMixin");
        }
        if (loadedMods.contains("ChromatiCraft")) {
            ModCheck.ccLoad();
            mixins.add("chromaticraft.StructurePasswordCheckPasswordMixin");
            mixins.add("chromaticraft.TileEntityItemCollectorEventMixin");
            mixins.add("chromaticraft.ItemBulkMoverMixin");
        }
        if (loadedMods.contains("manametalmod")) {
            ModCheck.manametalmodLoad();
        }

        return mixins;
    }

}
