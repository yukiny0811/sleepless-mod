package com.yukiny.sleeplessmod;

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

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event){

    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event){

    }
}
