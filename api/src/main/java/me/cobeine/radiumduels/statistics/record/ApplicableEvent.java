package me.cobeine.radiumduels.statistics.record;

import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * The interface Applicable event.
 *
 * @param <E> the type parameter
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
public interface ApplicableEvent<E extends Event> {

    /**
     * Apply consumer.
     *
     * @return the consumer
     */
    @NotNull Consumer<E> apply();


}
