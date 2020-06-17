package com.yukiny.sleeplessmod.items;

import com.yukiny.sleeplessmod.SleeplessMod;
import com.yukiny.sleeplessmod.others.Organizer;
import com.yukiny.sleeplessmod.others.tick_manager.TickManagement;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RedBullEnergy extends ItemFood implements TickManagement {

    public static final int HYPER_TICK_LENGTH_REDBULL = 5000;

    public RedBullEnergy(){
        super(1, 0.5f, false);
        setCreativeTab(SleeplessMod.sleeplessTab);
        setRegistryName("energy_drink_redbull");
        setUnlocalizedName(SleeplessMod.MODID + "energy_drink_redbull");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        Organizer.isRedBull = true;
        setValueToTickManager(() -> {
            Organizer.isRedBull = false;
        }, HYPER_TICK_LENGTH_REDBULL);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
