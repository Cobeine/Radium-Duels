package me.cobeine.radiumduels.statistics.record;

import org.jetbrains.annotations.NotNull;

/**
 * Create a fast record without creating a class for it
 *
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
public class FastRecord extends AbstractRecord {


    private <K extends Enum<K>> FastRecord(K key) {
        super(key);
    }

    /**
     * Create a fast record without creating a class for it
     *
     * @param <K> the type parameter
     * @param key the key
     * @return the fast record
     */
    public static @NotNull <K extends Enum<K>> FastRecord of(K key) {
        return new FastRecord(key);
    }

}
