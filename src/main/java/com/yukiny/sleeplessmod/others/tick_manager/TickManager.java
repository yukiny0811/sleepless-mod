package com.yukiny.sleeplessmod.others.tick_manager;

import com.yukiny.sleeplessmod.SleeplessMod;
import com.yukiny.sleeplessmod.others.Organizer;
import com.yukiny.sleeplessmod.others.player_extended_capability.PlayerExtendedCapabilities;
import com.yukiny.sleeplessmod.others.player_extended_capability.PlayerExtendedCapabilityProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.List;

public class TickManager {
    public static List<Runnable> runner = new ArrayList<>();
    public static List<Integer> delay = new ArrayList<>();
    public static List<Integer> delayCount = new ArrayList<>();

    public static List<Runnable> renderRunner = new ArrayList<>();
    public static List<Integer> renderDelay = new ArrayList<>();
    public static List<Integer> renderDelayCount = new ArrayList<>();

    @SubscribeEvent
    public void updateTick(TickEvent.PlayerTickEvent event){
        for(int i = 0; i < delay.size(); i++){
            delayCount.set(i, delayCount.get(i) + 1);
            if(delayCount.get(i) > delay.get(i)){
                runner.get(i).run();
                runner.remove(i);
                delay.remove(i);
                delayCount.remove(i);
            }
        }
        if(Organizer.isWaitingForCapabilityUpdate) {
            if (event.player instanceof EntityPlayerMP) {
                PlayerExtendedCapabilities player_cap = event.player.getCapability(PlayerExtendedCapabilityProvider.PLAYER_CAP, null);
                player_cap.setFusaiValue(player_cap.getFusaiValue() + 1);
                Organizer.fusaiValue = player_cap.getFusaiValue();
                Organizer.isWaitingForCapabilityUpdate = false;
            }
        }
    }

    @SubscribeEvent
    public static void renderTick(RenderWorldLastEvent event){
        for(int i = 0; i < renderDelay.size(); i++){
            renderDelayCount.set(i, renderDelayCount.get(i) + 1);
            if(renderDelayCount.get(i) > renderDelay.get(i)){
                renderRunner.get(i).run();
                renderRunner.remove(i);
                renderDelay.remove(i);
                renderDelayCount.remove(i);
            }
        }
    }
}
