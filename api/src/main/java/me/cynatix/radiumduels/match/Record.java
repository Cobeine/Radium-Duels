package me.cynatix.radiumduels.match;

import lombok.Builder;

/**
 * @author <a href="https://github.com/0Saturnine">0Saturnine</a>
 */
@Builder
public class Record<K extends Enum<K>> {

    K key;
    int value;

    private Record(K key) {
        this.key = key;
        this.value = 0;
    }

    public static <K extends Enum<K>> Record<K> of(K key) {
        return new Record<>(key);
    }

    public Record<K> increment(int i) {
        value = value + i;
        return this;
    }

    public Record<K> decrement(int i) {
        value = value - i;
        return this;
    }

    public Record<K> increment() {
        return increment(1);

    }

    public Record<K> decrement() {
        return decrement(1);
    }

}
