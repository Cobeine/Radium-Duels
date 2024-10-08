package me.cobeine.radiumduels.exceptions;

import me.cobeine.radiumduels.arena.Arena;
import me.cobeine.radiumduels.user.Contender;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class ArenaLeaveException extends Exception{

    public ArenaLeaveException(Contender contender, Arena arena, String tx) {
        super(String.format("Contender '%s' failed to leave arena '%s': %s",
                contender.getName(), arena.name() + arena.hashCode(), tx));
    }


}
