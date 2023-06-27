package me.cobeine.radiumduels.command.test;

import me.cobeine.radiumduels.command.annotations.Default;
import me.cobeine.radiumduels.command.annotations.ICommand;
import org.bukkit.entity.Player;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@ICommand(name = "test")
public class TestCommand {

    @Default
    public void onExecute(Player player) {
        player.sendMessage("fuck you");
    }

}
