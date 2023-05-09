package me.cobeine.radiumduels.spigot.impl.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.cobeine.radiumduels.statistics.AbstractRecordPool;
import me.cobeine.radiumduels.user.Contender;
import me.cobeine.radiumduels.user.User;

import java.util.UUID;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
@AllArgsConstructor
public class DuelsContender implements Contender {

    private final String name;
    private final UUID uniqueID;
    AbstractRecordPool recordPool;
    User user;
}
