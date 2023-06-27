package me.cobeine.radiumduels.command;

import me.cobeine.radiumduels.platform.SpigotPlugin;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
public class CommandManager {
    SpigotPlugin plugin;
    private CommandManager(SpigotPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerCommand() {

    }
    public static CommandManager register(SpigotPlugin plugin) {
        return new CommandManager(plugin);
    }


}
