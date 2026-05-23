package me.garbageatsb.loopCommand;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public class LoopManager {
    public static final List<CommandSender> running = new ArrayList<>();

    public static void loop(CommandSender sender, int times, int delay, String command) {
        running.add(sender);
        BukkitTask task = new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if (i < times && running.contains(sender)) {
                    Bukkit.dispatchCommand(sender, command);
                }
                else {
                    running.remove(sender);
                    sender.sendMessage("§aLoop finished!");
                    this.cancel();
                    return;
                }
                i++;
            }
        }.runTaskTimer(LoopPlugin.getInstance(), 0, delay);

        //This is kinda weird I think but if you don't have it and you stop a loop and start one before the
        //next iteration was supposed to happen it wouldn't know to cancel the first loop so you'd have
        //both running at once.
        new BukkitRunnable() {

            @Override
            public void run() {
                if (!running.contains(sender)) {
                    task.cancel();
                    this.cancel();
                }
            }
        }.runTaskTimer(LoopPlugin.getInstance(), 0, 1);


    }

    public static boolean stopLooping(CommandSender sender) {
        return running.remove(sender);

    }

    public static boolean isLooping(CommandSender sender) {
        return running.contains(sender);
    }
}
