package me.cobeine.radiumduels.user;

import me.cobeine.radiumduels.statistics.AbstractRecordPool;

import java.util.UUID;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public interface IUser {

    String getName();

    UUID getUniqueID();

    AbstractRecordPool getStatistics();

    UserState getUserState();
    void acceptMatchRecordPool(AbstractRecordPool recordPool);
}
