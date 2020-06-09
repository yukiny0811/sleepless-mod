package com.yukiny.sleeplessmod;

import com.yukiny.sleeplessmod.debug.DebugCommand;
import com.yukiny.sleeplessmod.entry.SpCapabilities;
import com.yukiny.sleeplessmod.entry.SpEvents;
import com.yukiny.sleeplessmod.entry.SpItems;
import com.yukiny.sleeplessmod.others.SleeplessTab;
import net.minecraft.creativetab.CreativeTabs;
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

    public static SleeplessTab sleeplessTab = new SleeplessTab("Sleepless Mod");

    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
        boolean isClient = event.getSide().isClient();
        SpCapabilities.register();
        SpItems.init();
        SpItems.register(isClient);
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
