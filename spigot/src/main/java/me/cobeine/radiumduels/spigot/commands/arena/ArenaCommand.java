package me.cobeine.radiumduels.spigot.commands.arena;

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
public class ArenaCommand {


    public void createArena(Player player, String map, ArenaType type) {
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
