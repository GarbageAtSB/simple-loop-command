package me.garbageatsb.loopCommand.commands;

import me.garbageatsb.loopCommand.LoopManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LoopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("loop.use")) {
            sender.sendMessage("§cYou are not allowed to do that!");
            return true;
        }

        if (args.length < 2) {
            sender.sendMessage("§cUsage: /loop <times> [<delay>] <command>");
            return true;
        }

        int amount;
        try {
            amount = Integer.parseInt(args[0]);
        } catch(IllegalArgumentException e) {
            sender.sendMessage("§cUsage: /loop <times> [<delay>] <command>");
            return true;
        }
        int commandStartIndex = 2;
        int delay = 1;

        try {
            delay = Integer.parseInt(args[1]);
            if (args.length < 3) {
                sender.sendMessage("§cUsage: /loop <times> [<delay>] <command>");
                return true;
            }
        } catch (NumberFormatException e) {
            commandStartIndex = 1;
        }

        StringBuilder commandBuilder = new StringBuilder();
        for (int i = commandStartIndex; i < args.length - 1; i++) {
            commandBuilder.append(args[i]).append(" ");
        }
        commandBuilder.append(args[args.length - 1]);

        if (LoopManager.isLooping(sender)) {
            sender.sendMessage("§cYou must cancel your loop with /stoploop before starting a new one!");
            return true;
        }

        LoopManager.loop(sender, amount, delay, commandBuilder.toString());
        sender.sendMessage("§aStarted looping command §b" + commandBuilder + "§e " + amount
        + "§a times with §e" + delay + "§a ticks of delay!");






        return true;
    }
}
