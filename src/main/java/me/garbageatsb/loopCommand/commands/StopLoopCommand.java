package me.garbageatsb.loopCommand.commands;

import me.garbageatsb.loopCommand.LoopManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StopLoopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("loop.use")) {
            sender.sendMessage("§cYou are not allowed to do that!");
            return true;
        }

        if (LoopManager.stopLooping(sender)) {
            sender.sendMessage("§aStopped looping!");
        }
        else {
            sender.sendMessage("§cYou aren't looping anything!");
        }
        return true;
    }
}
