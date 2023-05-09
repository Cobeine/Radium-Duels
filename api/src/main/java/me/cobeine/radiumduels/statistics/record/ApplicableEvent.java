package me.cobeine.radiumduels.statistics.record;

import org.bukkit.event.Event;

/**
 * The interface Applicable event.
 *
 * @param <E> the type parameter
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
public interface ApplicableEvent<E extends Event> {

    boolean apply(E event);


}
