package com.passengerdb.mmnhutils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import com.passengerdb.mmnhutils.fixes.ModCheck;

@LateMixin
public class LateMixinsLoader implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.mmnhutils.late.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedMods) {

        List<String> mixins = new ArrayList<>();

        if (loadedMods.contains("DragonAPI")) ModCheck.dapiLoad();
        if (loadedMods.contains("ChromatiCraft")) {
            ModCheck.ccLoad();
            mixins.add("chromaticraft.StructurePasswordCheckPasswordMixin");
        }

        return mixins;
    }

}
