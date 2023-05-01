package me.cynatix.radiumduels.exceptions;

import me.cynatix.radiumduels.arena.Arena;
import me.cynatix.radiumduels.user.Contender;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */

public class ArenaGenerationException extends Exception {
    public ArenaGenerationException(String tx) {
        super(String.format("Failed to generate arena: %s", tx));
    }


}   
