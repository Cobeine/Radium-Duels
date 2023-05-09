package me.cobeine.radiumduels.user;

import me.cobeine.radiumduels.statistics.AbstractRecordPool;

import java.util.UUID;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public interface User {

    String getName();

    UUID getUniqueID();

    AbstractRecordPool getStatistics();

    UserState getUserState();
    void acceptRecordPool(AbstractRecordPool recordPool);

    default void updateRecord(Enum<?> key, int value) {
        if (getStatistics().getRecord(key).isPresent()) {
            getStatistics().getRecord(key).get().set(value);
        }
    }

    Contender createNewContender();
}
