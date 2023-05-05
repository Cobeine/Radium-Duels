package me.cynatix.radiumduels.events;

import com.avaje.ebean.validation.NotNull;
import lombok.Getter;
import me.cynatix.radiumduels.arena.Arena;
import me.cynatix.radiumduels.user.Contender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
public class ArenaJoinEvent extends Event {
    public static final HandlerList HANDLERS = new HandlerList();
   private final @NotNull Arena arena;
   private final @NotNull Contender contender;
   private final @NotNull String[] joinData;
    public ArenaJoinEvent(Arena arena, Contender contender, String[] joinData) {
        this.arena = arena;
        this.contender = contender;
        this.joinData = joinData;
    }
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

}
