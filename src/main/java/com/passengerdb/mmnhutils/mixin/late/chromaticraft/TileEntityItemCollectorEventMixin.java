package com.passengerdb.mmnhutils.mixin.late.chromaticraft;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.passengerdb.mmnhutils.MMNHUtilsConfig;

import Reika.ChromatiCraft.ChromaticEventManager;

@Mixin(value = ChromaticEventManager.class, remap = false)
public class TileEntityItemCollectorEventMixin {

    @Inject(method = "preSpawnItemXP", at = @At(value = "RETURN", ordinal = 0))
    private void preSpawnItemXP(EntityJoinWorldEvent evt, CallbackInfo ci) {
        if (!MMNHUtilsConfig.isChangeItemCollectorCollectItemFromEventBehavior() || !evt.isCanceled()) return;

        if (evt.entity instanceof EntityItem) {
            EntityItem ei = (EntityItem) evt.entity;
            evt.setCanceled(false);
            ItemStack is = ei.getEntityItem()
                .copy();
            is.stackSize = 0;
            ei.setEntityItemStack(is);
            ei.setDead();
        }
    }

}
