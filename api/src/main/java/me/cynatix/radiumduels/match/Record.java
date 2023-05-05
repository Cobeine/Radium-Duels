package me.cynatix.radiumduels.match;

import lombok.Builder;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Builder
public class Record {

    String key;
    int value;

    private Record(String key) {
        this.key = key;
        this.value = 0;
    }

    public static Record of(String key) {
        return new Record(key);
    }

    public Record increment(int i) {
        value = value + i;
        return this;
    }

    public Record decrement(int i) {
        value = value - i;
        return this;
    }

    public Record increment() {
        return increment(1);

    }

    public Record decrement() {
        return decrement(1);
    }

}
