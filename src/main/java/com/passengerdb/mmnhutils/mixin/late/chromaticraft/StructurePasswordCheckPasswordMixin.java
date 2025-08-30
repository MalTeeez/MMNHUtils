package com.passengerdb.mmnhutils.mixin.late.chromaticraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import com.passengerdb.mmnhutils.MMNHUtilsConfig;

import Reika.ChromatiCraft.Auxiliary.ElementEncodedNumber;
import Reika.ChromatiCraft.Block.Dimension.Structure.BlockStructureDataStorage.TileEntityStructurePassword;

@Mixin(value = TileEntityStructurePassword.class, remap = false)
public class StructurePasswordCheckPasswordMixin {

    @ModifyVariable(
        method = "checkPassword",
        at = @At(
            value = "INVOKE",
            target = "LReika/DragonAPI/Libraries/ReikaPlayerAPI;isReika(Lnet/minecraft/entity/player/EntityPlayer;)Z"),
        name = "pass")
    private ElementEncodedNumber modifyElementEncodedNumber(ElementEncodedNumber orig) {

        if (!MMNHUtilsConfig.isEnableStructureBypassKeyCalculationFix()) return orig;

        return new ElementEncodedNumber(orig.originalValue, 8);

    }

}
