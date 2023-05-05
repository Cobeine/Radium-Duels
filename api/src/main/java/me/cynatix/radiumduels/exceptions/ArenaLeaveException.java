package me.cynatix.radiumduels.exceptions;

import me.cynatix.radiumduels.arena.Arena;
import me.cynatix.radiumduels.user.Contender;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class ArenaLeaveException extends Exception{

    public ArenaLeaveException(Contender contender, Arena arena, String tx) {
        super(String.format("Contender '%s' failed to leave arena '%s': %s",
                contender.name(), arena.name() + arena.hashCode(), tx));
    }


}
