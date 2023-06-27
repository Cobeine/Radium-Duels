package me.cobeine.radiumduels.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public abstract class AbstractCommand<U extends CommandSender> implements CommandExecutor{


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }

}
