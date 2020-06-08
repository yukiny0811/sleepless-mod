package com.yukiny.sleeplessmod.events;

import com.yukiny.sleeplessmod.others.Organizer;
import com.yukiny.sleeplessmod.others.player_extended_capability.PlayerExtendedCapabilities;
import com.yukiny.sleeplessmod.others.player_extended_capability.PlayerExtendedCapabilityProvider;
import com.yukiny.sleeplessmod.others.tick_manager.TickManagement;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class PlayerExtendedCapabilityManageEvent implements TickManagement {
    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if (event == null) return;

        if (event.getEntity() == null) return;

        if (!(event.getEntity() instanceof EntityPlayerMP)) return;

        EntityPlayer player = (EntityPlayer) event.getEntity();

        PlayerExtendedCapabilities player_cap = player.getCapability(PlayerExtendedCapabilityProvider.PLAYER_CAP, null);

        player_cap.setFusaiValue(0);
    }

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event){
        if(event == null) return;

        setValueToTickManager(()->{
            setValue();
        }, 50);
    }

    private void setValue(){
        Organizer.isWaitingForCapabilityUpdate = true;
        setValueToTickManager(()->{
            setValue();
        }, 50);
    }
}
