package com.yukiny.sleeplessmod.others.player_extended_capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public interface PlayerExtendedCapabilities {
    void setFusaiValue(int fusaiValue);
    int getFusaiValue();

    class PlayerExtendedCap implements PlayerExtendedCapabilities{
        private int fusaiValue = 0;

        @Override
        public void setFusaiValue(int fusaiValue) {
            this.fusaiValue = fusaiValue;
        }

        @Override
        public int getFusaiValue() {
            return this.fusaiValue;
        }
    }

    class Storage implements Capability.IStorage<PlayerExtendedCapabilities>{
        @Override
        public NBTBase writeNBT(Capability<PlayerExtendedCapabilities> capability, PlayerExtendedCapabilities instance, EnumFacing side) {
            return new NBTTagInt(instance.getFusaiValue());
        }

        @Override
        public void readNBT(Capability<PlayerExtendedCapabilities> capability, PlayerExtendedCapabilities instance, EnumFacing side, NBTBase nbt) {
            instance.setFusaiValue(((NBTPrimitive)nbt).getInt());
        }
    }
}
