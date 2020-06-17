package com.yukiny.sleeplessmod.render;

import com.yukiny.sleeplessmod.SleeplessMod;
import com.yukiny.sleeplessmod.others.Organizer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EffectGuiRender {

    @SubscribeEvent
    public void doRender(RenderGameOverlayEvent.Post event){
        if(event.getType() == null) return;
        if(event.getType() != RenderGameOverlayEvent.ElementType.ALL) return;
        if(Minecraft.getMinecraft().thePlayer == null) return;
        if(Minecraft.getMinecraft().theWorld == null) return;

        EntityPlayer player  = Minecraft.getMinecraft().thePlayer;

        if(player.isSpectator()) return;

        GlStateManager.pushMatrix();

        int sizeX = event.getResolution().getScaledWidth();
        int sizeY = event.getResolution().getScaledHeight();

        int left = sizeX - 60;
        int top = sizeY - 220;
        int width = 70;
        int height = 50;

        GlStateManager.color(0.6f, 1f, 0.6f, 1f);

        GlStateManager.enableBlend();

        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(SleeplessMod.MODID, "textures/gui/monster_effect.png"));

        drawDispTexture(left, top, width, height);

        GlStateManager.popMatrix();
    }

    @SubscribeEvent
    public void doRender2(RenderGameOverlayEvent.Post event){
        if(event.getType() == null) return;
        if(event.getType() != RenderGameOverlayEvent.ElementType.ALL) return;
        if(Minecraft.getMinecraft().thePlayer == null) return;
        if(Minecraft.getMinecraft().theWorld == null) return;

        EntityPlayer player  = Minecraft.getMinecraft().thePlayer;

        if(player.isSpectator()) return;

        GlStateManager.pushMatrix();

        int sizeX = event.getResolution().getScaledWidth();
        int sizeY = event.getResolution().getScaledHeight();

        int left = sizeX - 60;
        int top = sizeY - 190;
        int width = 70;
        int height = 50;

        GlStateManager.color(1f, 0.6f, 0.6f, 1f);

        GlStateManager.enableBlend();

        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(SleeplessMod.MODID, "textures/gui/redbull_effect.png"));

        drawDispTexture(left, top, width, height);

        GlStateManager.popMatrix();
    }

    public void drawDispTexture(int x, int y, int width, int height) {
        float f = 0.00390625F * 256;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        vertexbuffer.pos(x + 0, y + height, -90.0F).tex(0, f).endVertex();
        vertexbuffer.pos(x + width, y + height, -90.0F).tex(f, f).endVertex();
        vertexbuffer.pos(x + width, y + 0, -90.0F).tex(f, 0).endVertex();
        vertexbuffer.pos(x + 0, y + 0, -90.0F).tex(0, 0).endVertex();
        tessellator.draw();
    }

}
