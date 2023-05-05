package me.cynatix.radiumduels.queue;

import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public abstract class ScheduledQueue<T> extends BukkitRunnable implements Queue<T>  {

    public void run() {
        move();
    }
}
