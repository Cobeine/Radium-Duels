package me.cobeine.radiumduels.spigot;

import io.github.mqzn.commands.SpigotCommandManager;
import io.github.mqzn.commands.annotations.AnnotationParser;
import io.github.mqzn.commands.base.manager.CommandExecutionCoordinator;
import lombok.Getter;
import me.cobeine.radiumduels.platform.SpigotPlugin;
import me.cobeine.radiumduels.spigot.managers.ArenaManager;
import me.cobeine.radiumduels.spigot.managers.UserManager;
import me.cobeine.radiumduels.spigot.storage.mysql.MySQLConnection;
import me.cobeine.radiumduels.spigot.utils.ArenaWand;
import me.cobeine.sqllava.utils.Credentials;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
public class Core extends SpigotPlugin {
    public static @Getter Core instance;
    private MySQLConnection mySQLConnection;
    private UserManager userManager;
    private ArenaManager arenaManager;
    private SpigotCommandManager commandManager;


    private AnnotationParser<CommandSender> commandAnnotationParser;


    @Override
    public void init() {
        instance = this;
        userManager = new UserManager();
        arenaManager = new ArenaManager();
        try {
            this.mySQLConnection = new MySQLConnection(Credentials.defaultCredentials, 5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void registerCommands() {
        this.commandManager = new SpigotCommandManager(this, CommandExecutionCoordinator.Type.ASYNC);
        this.commandAnnotationParser = new AnnotationParser<>(commandManager);

    }

    @Override
    public void registerListeners() {

    }

    @Override
    public void fini() {
        instance = null;
        mySQLConnection.close();
        ArenaWand.getWands().clear();
    }
}
