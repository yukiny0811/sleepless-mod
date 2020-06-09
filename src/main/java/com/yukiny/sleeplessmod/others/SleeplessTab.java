package com.yukiny.sleeplessmod.others;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class SleeplessTab extends CreativeTabs {
    public SleeplessTab(String label){
        super(label);
    }

    @Override
    public Item getTabIconItem() {
        return Items.BED;
    }
}
