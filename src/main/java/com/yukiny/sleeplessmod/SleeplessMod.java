package com.yukiny.sleeplessmod;

import com.yukiny.sleeplessmod.debug.DebugCommand;
import com.yukiny.sleeplessmod.entry.SpCapabilities;
import com.yukiny.sleeplessmod.entry.SpEvents;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = SleeplessMod.MODID, version = SleeplessMod.VERSION)
public class SleeplessMod
{
    public static final String MODID = "sleeplessmod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
        boolean isClient = event.getSide().isClient();
        SpCapabilities.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        SpEvents.register();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event){

    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event){
        event.registerServerCommand(new DebugCommand());
    }
}
