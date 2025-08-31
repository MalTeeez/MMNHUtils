package com.passengerdb.mmnhutils.events.manametalmod;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.passengerdb.mmnhutils.MMNHUtilsConfig;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import project.studio.manametalmod.config.M3Config;
import project.studio.manametalmod.instance_dungeon.IDungeonBoss;

public class GenericM3EventHandler {

    private GenericM3EventHandler() {}

    public static final GenericM3EventHandler INSTANCE = new GenericM3EventHandler();

    @SubscribeEvent
    public void canDungeonEntityBeOutOfDungeon(LivingUpdateEvent event) {
        EntityLivingBase ent = event.entityLiving;

        if (MMNHUtilsConfig.isDisableM3DungeonMobAppearsInNonDungeonDimension()
            && M3Config.WorldInstanceDungeonID != ent.dimension
            && ent instanceof IDungeonBoss) {
            ent.setDead();
        }

    }

}
