package me.cobeine.radiumduels.spigot;

import lombok.Getter;
import me.cobeine.radiumduels.platform.SpigotPlugin;
import me.cobeine.radiumduels.spigot.impl.managers.UserManager;
import me.cobeine.radiumduels.spigot.impl.storage.mysql.MySQLConnection;
import me.cobeine.sqllava.utils.Credentials;
import org.bukkit.Bukkit;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
public class Core extends SpigotPlugin {
    public static @Getter Core instance;
    private MySQLConnection mySQLConnection;
    private UserManager userManager;

    @Override
    public void init() {
        instance = this;
        userManager = new UserManager();
        try {
            this.mySQLConnection = new MySQLConnection(Credentials.defaultCredentials, 5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
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
