package com.passengerdb.mmnhutils.mixin.late.chromaticraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import Reika.ChromatiCraft.TileEntity.Processing.TileEntitySpawnerReprogrammer;

@Mixin(value = TileEntitySpawnerReprogrammer.class, remap = false)
public class TileEntitySpawnerReprogrammerMixin {

    @ModifyVariable(method = "setMobType", at = @At("HEAD"), argsOnly = true, ordinal = 0)
    private String setMobType(String type) {
        Class<? extends Entity> mClass = EntityList.stringToClassMapping.get(type);
        if (mClass != null && isMobAllowed(mClass)) return type;
        return null;
    }

    @Shadow
    private static boolean isMobAllowed(Class<?> mob) {
        return false;
    }

}
