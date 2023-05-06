package me.cobeine.radiumduels.exceptions;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class ArenaGenerationException extends Exception {
    public ArenaGenerationException(String tx) {
        super(String.format("Failed to generate arena: %s", tx));
    }


}   
