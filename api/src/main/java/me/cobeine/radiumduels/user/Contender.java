package me.cobeine.radiumduels.user;

import me.cobeine.radiumduels.statistics.AbstractRecordPool;

import java.util.UUID;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public interface Contender {


    String getName();

    UUID getUniqueID();

    AbstractRecordPool getRecordPool();

    User getUser();

    default void applyStatistics() {
        getUser().acceptRecordPool(getRecordPool());
    }



}
