package com.yukiny.sleeplessmod.entry;

import com.yukiny.sleeplessmod.items.MonsterEnergy;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SpItems {

    public static Item monsterEnergy;

    public static void init(){
        monsterEnergy = new MonsterEnergy();
    }

    public static void register(boolean isClient){
        registerItem(monsterEnergy, isClient);
    }

    private static void registerItem(Item item, boolean isClient){
        GameRegistry.register(item);
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }
    }

    private static void registerItem(Item item, Item textureItem, boolean isClient){
        GameRegistry.register(item);
        if(isClient){
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(textureItem.getRegistryName(), "inventory"));
        }
    }
}
