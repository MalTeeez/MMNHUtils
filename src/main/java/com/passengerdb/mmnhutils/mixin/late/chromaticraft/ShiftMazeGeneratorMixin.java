package com.passengerdb.mmnhutils.mixin.late.chromaticraft;

import java.util.List;

import net.minecraft.world.World;

import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import Reika.ChromatiCraft.Block.Dimension.Structure.ShiftMaze.BlockShiftLock.Passability;
import Reika.ChromatiCraft.World.Dimension.Structure.ShiftMazeGenerator;
import Reika.DragonAPI.Instantiable.Data.Immutable.Coordinate;

@Mixin(value = ShiftMazeGenerator.class, remap = false)
public class ShiftMazeGeneratorMixin {

    @Shadow
    private List<Coordinate> toggleDoors;

    @Inject(
        method = "openStructure",
        at = @At(value = "FIELD", target = "toggleDoors:Ljava/util/List;", opcode = Opcodes.GETFIELD),
        cancellable = true)
    private void openStructure(World w, CallbackInfo c) {
        for (Coordinate coor : this.toggleDoors) {
            coor.setBlockMetadata(w, Passability.OPEN.ordinal());
        }
        c.cancel();
    }

}
