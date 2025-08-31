package com.passengerdb.mmnhutils.mixin.late.chromaticraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.passengerdb.mmnhutils.MMNHUtilsConfig;

import Reika.ChromatiCraft.Items.Tools.ItemBulkMover;

@Mixin(value = ItemBulkMover.class, remap = false)
public class ItemBulkMoverMixin {

    @Inject(method = "getInteraction", at = @At(value = "RETURN", ordinal = 1), cancellable = true)
    private void getInteraction(World world, int x, int y, int z, int side, EntityPlayer ep,
        CallbackInfoReturnable<Object> cir) {
        if (!MMNHUtilsConfig.isDisableItemMoverInteractWithISidedInventory()) return;

        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof ISidedInventory) cir.setReturnValue(null);

    }

}
