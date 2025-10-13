package com.passengerdb.mmnhutils.mixin.late.rotarycraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import Reika.RotaryCraft.TileEntities.Production.TileEntityWorktable;

@Mixin(value = TileEntityWorktable.class, remap = false)
public class TileEntityWorktableMixin {

    @ModifyConstant(method = "isNotUncraftable", constant = @Constant(stringValue = "bearing"))
    private String gearBoxNBTNameFix(String orig) {
        return "type";
    }

}
