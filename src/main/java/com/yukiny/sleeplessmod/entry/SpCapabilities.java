package com.yukiny.sleeplessmod.entry;

import com.yukiny.sleeplessmod.others.player_extended_capability.PlayerExtendedCapabilities;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class SpCapabilities {
    public static void register() {
        CapabilityManager.INSTANCE.register(PlayerExtendedCapabilities.class, new PlayerExtendedCapabilities.Storage(), PlayerExtendedCapabilities.PlayerExtendedCap.class);
    }
}
