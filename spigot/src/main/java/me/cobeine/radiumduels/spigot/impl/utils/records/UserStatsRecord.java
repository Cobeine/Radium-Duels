package me.cobeine.radiumduels.spigot.impl.utils.records;

import me.cobeine.radiumduels.spigot.impl.utils.records.stats.*;
import me.cobeine.radiumduels.statistics.AbstractRecordPool;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class UserStatsRecord extends AbstractRecordPool {


    public UserStatsRecord() {
        registerRecord(new MatchesRecord());
        registerRecord(new LosesRecord());
        registerRecord(new WinsRecord());
        registerRecord(new KillsRecord());
        registerRecord(new DeathsRecord());
    }


}
