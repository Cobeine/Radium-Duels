package me.cobeine.radiumduels.spigot.impl.utils.records;

import me.cobeine.radiumduels.statistics.AbstractRecordPool;
import me.cobeine.radiumduels.statistics.record.FastRecord;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class UserMatchRecord extends AbstractRecordPool {


    public UserMatchRecord() {
        registerRecord(FastRecord.of(StatsRecord.KILLS));
        registerRecord(FastRecord.of(StatsRecord.DEATHS));
    }


}
