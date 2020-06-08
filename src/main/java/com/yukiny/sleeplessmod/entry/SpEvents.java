package com.yukiny.sleeplessmod.entry;

import com.yukiny.sleeplessmod.events.PlayerExtendedCapabilityHandler;
import com.yukiny.sleeplessmod.events.PlayerExtendedCapabilityManageEvent;
import com.yukiny.sleeplessmod.others.tick_manager.TickManager;
import net.minecraftforge.common.MinecraftForge;

public class SpEvents {
    public static void register(){
        MinecraftForge.EVENT_BUS.register(new PlayerExtendedCapabilityManageEvent());
        MinecraftForge.EVENT_BUS.register(new PlayerExtendedCapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new TickManager());
    }
}
