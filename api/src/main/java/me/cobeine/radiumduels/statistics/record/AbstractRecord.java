package me.cobeine.radiumduels.statistics.record;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * The type Abstract record.
 *
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@SuppressWarnings("all")
@Getter
public abstract class AbstractRecord {

    private @NotNull final Enum<?> key;
    private int value;

    /**
     * Instantiates a new Abstract record.
     *
     * @param key the enum key
     */
    public @NotNull <K extends Enum<K>> AbstractRecord(K key) {
        this.key = key;
        this.value = 0;
    }

    /**
     * Increase the value by i
     *
     * @param i the value
     * @return the abstract record
     */
    public @NotNull AbstractRecord increment(int i) {
        value = value + i;
        return this;
    }

    /**
     * Decrease the value by i
     *
     * @param i the
     * @return the abstract record
     */
    public @NotNull AbstractRecord decrement(int i) {
        value = value - i;
        return this;
    }

    /**
     * Increase the value by 1
     *
     * @return the abstract record
     */
    public @NotNull  AbstractRecord increment() {
        return increment(1);
    }

    /**
     * Decrease the value by 1
     *
     * @return the abstract record
     */
    public @NotNull AbstractRecord decrement() {
        return decrement(1);
    }

    /**
     * reset the value to 0
     */
    public void clear() {
        this.value = 0;
    }

    public void set(int value) {
        this.value = value;
    }
}
