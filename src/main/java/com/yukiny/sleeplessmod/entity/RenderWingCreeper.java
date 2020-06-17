package com.yukiny.sleeplessmod.entity;

import com.yukiny.sleeplessmod.SleeplessMod;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWingCreeper extends RenderLiving<EntityWingCreeper> {
    private static final ResourceLocation wingCreeperTexture = new ResourceLocation(SleeplessMod.MODID,"textures/entity/creeper_wing2.png");
    public RenderWingCreeper(RenderManager renderManager){
        super(renderManager, new WingCreeperModel(), 0.5f);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityWingCreeper entity) {
        return wingCreeperTexture;
    }
}
