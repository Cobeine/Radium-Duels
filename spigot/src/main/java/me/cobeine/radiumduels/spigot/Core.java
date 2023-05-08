package me.cobeine.radiumduels.spigot;

import lombok.Getter;
import me.cobeine.radiumduels.platform.SpigotPlugin;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class Core extends SpigotPlugin {
    public static @Getter Core instance;


    @Override
    public void init() {
        instance = this;
    }

    @Override
    public void registerCommands() {
    }

    @Override
    public void registerListeners() {

    }

    @Override
    public void fini() {
        instance = null;
    }
}
