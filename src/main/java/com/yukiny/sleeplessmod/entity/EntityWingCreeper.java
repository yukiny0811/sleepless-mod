package com.yukiny.sleeplessmod.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class EntityWingCreeper extends EntityCreeper {
    public static final int ENTITY_ID = 2;
    private static final int FLOAT_TICK = 100;
    private boolean isFloat;
    private int count = 0;
    public EntityWingCreeper(World world){
        super(world);
        this.setNoGravity(true);
        isFloat = true;
        this.setHealth(100000);
    }

    @Override
    public boolean isImmuneToExplosions() {
        return true;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(isFloat){
            count += 1;
            if(count > FLOAT_TICK) {
                isFloat = false;
            }
            this.setPosition(this.getPositionVector().xCoord, this.getPositionVector().yCoord + 0.05, this.getPositionVector().zCoord);
//            this.getNavigator().tryMoveToXYZ(this.getPositionVector().xCoord, this.getPositionVector().yCoord + 0.05, this.getPositionVector().zCoord, 10);
        } else {
            if(Minecraft.getMinecraft().thePlayer != null){
                EntityPlayer player = Minecraft.getMinecraft().thePlayer;
                Vec3d direction = new Vec3d(player.getPositionVector().xCoord - this.getPositionVector().xCoord,
                        player.getPositionVector().yCoord - this.getPositionVector().yCoord,
                        player.getPositionVector().zCoord - this.getPositionVector().zCoord);
                direction = direction.normalize();
                double mul = 0.4d;
                direction = new Vec3d(direction.xCoord * mul, direction.yCoord * mul, direction.zCoord * mul);
                this.setPosition(this.getPositionVector().xCoord + direction.xCoord,
                        this.getPositionVector().yCoord + direction.yCoord,
                        this.getPositionVector().zCoord + direction.zCoord);
                this.getLookHelper().setLookPosition(player.getPositionVector().xCoord, player.getPositionVector().yCoord, player.getPositionVector().zCoord,
                        10f, this.getVerticalFaceSpeed());
                BlockPos bPos = new BlockPos((int)this.getPositionVector().xCoord, (int)this.getPositionVector().yCoord, (int)this.getPositionVector().zCoord);
                if(Minecraft.getMinecraft().getIntegratedServer().getEntityWorld() != null){
                    World world = Minecraft.getMinecraft().getIntegratedServer().getEntityWorld();
                    if(world.getBlockState(bPos).getBlock() != Blocks.AIR){
                        world.createExplosion(this, this.getPositionVector().xCoord, this.getPositionVector().yCoord, this.getPositionVector().zCoord, 3, true);
                    }
                }
            }
        }
    }
}
