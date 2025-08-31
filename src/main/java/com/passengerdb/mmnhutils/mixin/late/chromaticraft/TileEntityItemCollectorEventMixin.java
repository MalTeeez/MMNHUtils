package com.passengerdb.mmnhutils.mixin.late.chromaticraft;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.passengerdb.mmnhutils.MMNHUtilsConfig;

import Reika.ChromatiCraft.ChromaticEventManager;

@Mixin(value = ChromaticEventManager.class, remap = false)
public class TileEntityItemCollectorEventMixin {

    @Inject(method = "preSpawnItemXP", at = @At("HEAD"), cancellable = true)
    private void preSpawnItemXP(CallbackInfo c) {
        if (MMNHUtilsConfig.isDisableItemCollectorCollectItemFromEvent()) c.cancel();
    }

}
