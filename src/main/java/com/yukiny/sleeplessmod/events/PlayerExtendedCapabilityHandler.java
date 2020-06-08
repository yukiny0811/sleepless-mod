package com.yukiny.sleeplessmod.events;

import com.yukiny.sleeplessmod.SleeplessMod;
import com.yukiny.sleeplessmod.others.player_extended_capability.PlayerExtendedCapabilityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerExtendedCapabilityHandler {
    public static final ResourceLocation PLAYER_CAP = new ResourceLocation(SleeplessMod.MODID, "player_cap");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if(!(event.getObject() instanceof EntityPlayer)) return;

        event.addCapability(PLAYER_CAP, new PlayerExtendedCapabilityProvider());
    }
}
