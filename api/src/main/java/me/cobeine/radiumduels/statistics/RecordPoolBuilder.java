package me.cobeine.radiumduels.statistics;

import org.jetbrains.annotations.NotNull;

/**
 * An empty class to easily create a record pool without making a class for it
 *
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
public class RecordPoolBuilder extends AbstractRecordPool{

    public static @NotNull RecordPoolBuilder builder() {
        return new RecordPoolBuilder();
    }
}
