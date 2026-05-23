package me.garbageatsb.loopCommand;

import me.garbageatsb.loopCommand.commands.LoopCommand;
import me.garbageatsb.loopCommand.commands.StopLoopCommand;
import me.garbageatsb.loopCommand.listeners.OnPlayerLeave;
import org.bukkit.plugin.java.JavaPlugin;

public final class LoopPlugin extends JavaPlugin {

    private static LoopPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new OnPlayerLeave(), this);
        //Is it bad practice to register all commands in onEnable instead of making a specific method
        //if there are only 2 of them? idk tbh
        getCommand("loop").setExecutor(new LoopCommand());
        getCommand("stoploop").setExecutor(new StopLoopCommand());
        System.out.println("Enabled loop plugin!");
    }

    public static LoopPlugin getInstance() {
        return plugin;
    }

    @Override
    public void onDisable() {

    }
}
