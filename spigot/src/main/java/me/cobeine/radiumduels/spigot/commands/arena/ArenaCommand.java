package me.cobeine.radiumduels.spigot.commands.arena;

import io.github.mqzn.commands.annotations.base.Arg;
import io.github.mqzn.commands.annotations.base.Command;
import io.github.mqzn.commands.annotations.base.ExecutionMeta;
import me.cobeine.radiumduels.arena.ArenaType;
import me.cobeine.radiumduels.exceptions.ArenaGenerationException;
import me.cobeine.radiumduels.spigot.Core;
import me.cobeine.radiumduels.spigot.utils.ArenaWand;
import me.cobeine.radiumduels.spigot.utils.SpigotArena;
import org.bukkit.entity.Player;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@SuppressWarnings("all")
@Command(name = "arena", description = "arena management command", permission = "duels.admin")
public class ArenaCommand {


    @ExecutionMeta()
    public void createArena(Player player, @Arg(id = "map") String map, @Arg(id = "type") ArenaType type) {
        ArenaWand wand = ArenaWand.getWands().getOrDefault(player.getUniqueId(), ArenaWand.empty());
        if (!wand.isComplete()) {
            player.sendMessage(Core.error("&7One or more position is not set!"));
            return;
        }
        try {
            Core.getInstance().getArenaManager().generateNewArena(new SpigotArena(map, type,wand));
        } catch (ArenaGenerationException exception) {
            player.sendMessage(Core.error(exception.getMessage()));
        }
    }
}
