package com.passengerdb.mmnhutils.mixin.late.dragonapi;

import java.util.function.BiFunction;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.passengerdb.mmnhutils.MMNHUtilsConfig;

import Reika.DragonAPI.Libraries.ReikaEntityHelper;

@Mixin(value = ReikaEntityHelper.class, remap = false)
public class DamageArmorItemMixin {

    @Inject(
        method = "damageArmorItem",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/item/ItemStack;damageItem(ILnet/minecraft/entity/EntityLivingBase;)V",
            remap = true),
        cancellable = true)
    private static void damageArmorItem(EntityLivingBase e, int slot, int amt,
        BiFunction<ItemStack, Integer, Integer> handle, CallbackInfoReturnable<Integer> cir) {
        if (!MMNHUtilsConfig.isEnableDamageArmorItemFix()) return;

        ItemStack arm = e.getEquipmentInSlot(slot);
        if (!arm.isItemStackDamageable()) cir.setReturnValue(Integer.valueOf(0));

    }

}
