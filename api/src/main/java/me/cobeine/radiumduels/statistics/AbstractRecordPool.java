package me.cobeine.radiumduels.statistics;

import me.cobeine.radiumduels.statistics.record.AbstractRecord;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;

/**
 * The type Abstract record pool.
 *
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
public abstract class AbstractRecordPool {

    private @NotNull final HashMap<Enum<?>, AbstractRecord> pool;

    /**
     * Instantiates a new Abstract record pool.
     */
    public AbstractRecordPool(){
        pool = new HashMap<>();
    }

    /**
     * Register record.
     *
     * @param <E>    the type parameter
     * @param key    the key
     * @param record the record
     */
    public @NotNull <E extends Enum<E>> AbstractRecordPool registerRecord(@NotNull E key, @NotNull AbstractRecord record) {
        pool.put(key, record);
        return this;
    }

    /**
     * Register record.
     *
     * @param record the record
     */
    public @NotNull AbstractRecordPool registerRecord(@NotNull AbstractRecord record) {
        pool.put(record.getKey(), record);
        return this;
    }

    /**
     * Gets a specific record.
     *
     * @param <T> the type parameter
     * @param key the key
     * @return the record
     */
    public <T extends Enum<T>> AbstractRecord getRecord(@NotNull T key) {
        return pool.get(key);
    }

    /**
     * Reset the records inside the pool.
     */
    public void resetPool() {
        pool.values().forEach(AbstractRecord::clear);
    }

    /**
     * Empty the pool from all records.
     */
    public void emptyPool() {
        pool.clear();
    }

    /**
     * Gets all available records.
     *
     * @return the records
     */
    public @NotNull Collection<AbstractRecord> getALL() {
        return pool.values();
    }


    /**
     * Gets the hashmap.
     *
     * @return the pool
     */
    public @NotNull HashMap<Enum<?>, AbstractRecord> getPool() {
        return pool;
    }
}
