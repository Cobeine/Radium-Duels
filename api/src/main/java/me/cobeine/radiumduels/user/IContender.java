package me.cobeine.radiumduels.user;

import me.cobeine.radiumduels.statistics.AbstractRecordPool;

import java.util.UUID;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public interface IContender {


    String getName();

    UUID getUniqueID();

    AbstractRecordPool getRecordPool();

    IUser getUser();

    default void applyStatistics() {
        getUser().acceptMatchRecordPool(getRecordPool());
    }



}
