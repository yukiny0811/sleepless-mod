package com.yukiny.sleeplessmod.debug;

import com.yukiny.sleeplessmod.others.player_extended_capability.PlayerExtendedCapabilities;
import com.yukiny.sleeplessmod.others.player_extended_capability.PlayerExtendedCapabilityProvider;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.List;

public class DebugCommand extends CommandBase {
    public DebugCommand() {

    }

    @Override
    public String getCommandName() {
        return "debug";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "debug <text>";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return null;
    }

    @Override
    public int compareTo(ICommand p_compareTo_1_) {
        return 0;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) return;

        EntityPlayerMP player = getCommandSenderAsPlayer(sender);

        try{
            if (args[0].equals("fusaiValue")) {
                PlayerExtendedCapabilities player_cap = player.getCapability(PlayerExtendedCapabilityProvider.PLAYER_CAP, null);
                player.addChatComponentMessage(new TextComponentString(String.valueOf(player_cap.getFusaiValue())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
