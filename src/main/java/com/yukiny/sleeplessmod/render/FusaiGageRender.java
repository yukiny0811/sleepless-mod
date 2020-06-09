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
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FusaiGageRender {
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



        int left = sizeX / 2 - 91;
        int top = sizeY - 39;

        float percentage =(float) Organizer.fusaiValue / (float)Organizer.MAX_FUSAI_VALUE;

        int heartPlaceWidth = 180;

        if(percentage < 1f / 8f){
            GlStateManager.color(0.2f, 1f, 0.2f, 1f);
        } else if (percentage < 2f / 8f){
            GlStateManager.color(0.2f, 0.2f, 1f, 1f);
        } else if (percentage < 3f / 8f){
            GlStateManager.color(1f, 1f, 0.2f, 1f);
        }else if (percentage < 4f / 8f){
            GlStateManager.color(1f, 0.2f, 0.2f, 1f);
        } else if (percentage < 5f / 8f){
            GlStateManager.color(1f, 0.2f, 1f, 1f);
        }else if (percentage < 6f / 8f){
            GlStateManager.color(0.2f, 1f, 1f, 1f);
        }else if (percentage < 7f / 8f){
            GlStateManager.color(0.1f, 0.1f, 0.1f, 1f);
        }else {
            GlStateManager.color((float)Math.random() , (float)Math.random(), (float)Math.random(), 1f);
        }

        GlStateManager.enableBlend();

        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(SleeplessMod.MODID, "textures/gui/fusai_gage.png"));

        drawDispTexture(left, top - 9 - 3, (int)Math.floor((float)heartPlaceWidth * percentage), 9);

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
