package me.cobeine.radiumduels.exceptions;

import lombok.Getter;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class ArenaCreationException extends Exception {
    private final @Getter ExceptionCause cause;
    public ArenaCreationException(String tx, ExceptionCause cause) {
        super(String.format("Failed to create arena (%s): %s", cause,tx));
        this.cause = cause;
    }

    public enum ExceptionCause {
        UNKNOWN,NAME_USED
    }



}   
