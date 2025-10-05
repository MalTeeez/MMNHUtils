package com.passengerdb.mmnhutils.mixin.late.matteroverdrive;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.passengerdb.mmnhutils.GenericUtils;

import matteroverdrive.entity.monster.EntityRougeAndroidMob;

@Mixin(EntityRougeAndroidMob.class)
public abstract class EntityRougeAndroidMobMixin extends EntityMob {

    protected EntityRougeAndroidMobMixin(World w) {
        super(w);
    }

    @Inject(method = "getCustomNameTag", at = @At("HEAD"), cancellable = true)
    private void getCustomNameTag(CallbackInfoReturnable<String> cir) {

        EnumChatFormatting color = this.getNameColor();
        String oldName = GenericUtils.getTextWithoutFormattingCodes(this.dataWatcher.getWatchableObjectString(10));
        cir.setReturnValue(color != null ? color + oldName : oldName);

    }

    @Shadow
    protected abstract EnumChatFormatting getNameColor();

}
