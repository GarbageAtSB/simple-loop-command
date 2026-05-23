package me.garbageatsb.loopCommand.listeners;

import me.garbageatsb.loopCommand.LoopManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnPlayerLeave implements Listener {

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        LoopManager.stopLooping(event.getPlayer());
    }

}
