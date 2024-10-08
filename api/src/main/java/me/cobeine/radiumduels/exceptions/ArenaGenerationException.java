package me.cobeine.radiumduels.exceptions;

import lombok.Getter;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class ArenaGenerationException extends Exception {
    private final @Getter ExceptionCause cause;
    public ArenaGenerationException(String tx,ExceptionCause cause) {
        super(String.format("Failed to generate arena (%s): %s", cause,tx));
        this.cause = cause;
    }

    private enum ExceptionCause {
        UNKNOWN,NAME_USED
    }



}   
