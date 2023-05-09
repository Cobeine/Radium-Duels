package me.cobeine.radiumduels.events;

import lombok.Getter;
import me.cobeine.radiumduels.arena.Arena;
import me.cobeine.radiumduels.user.Contender;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
public class ArenaLeaveEvent extends Event {
    public static final HandlerList HANDLERS = new HandlerList();
   private final @NotNull Arena arena;
   private final @NotNull Contender contender;
   private final @NotNull Arena.ArenaLeaveReason leaveReason;
    public ArenaLeaveEvent(@NotNull Arena arena, @NotNull Contender contender, @NotNull  Arena.ArenaLeaveReason joinData) {
        this.arena = arena;
        this.contender = contender;
        this.leaveReason = joinData;
    }
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

}
