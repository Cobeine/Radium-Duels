package me.cobeine.radiumduels.platform;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public abstract class SpigotPlugin extends JavaPlugin implements DuelsPlugin {


    public void onEnable() {
        init();
    }

    public void onDisable() {
        fini();
    }

}
