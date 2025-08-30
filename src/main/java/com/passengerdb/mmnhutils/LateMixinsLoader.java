package com.passengerdb.mmnhutils;

import java.util.Collections;
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

        if (loadedMods.contains("DragonAPI")) ModCheck.dapiLoad();
        if (loadedMods.contains("ChromatiCraft")) ModCheck.ccLoad();

        return Collections.emptyList();
    }

}
