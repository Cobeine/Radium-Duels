package me.cobeine.radiumduels.spigot.impl.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class PlayerConnectionListener implements Listener {
    public ExecutorService pool = Executors.newFixedThreadPool(5);
    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        pool.submit(() -> {

        });
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        pool.submit(() -> {

        });
    }


}
