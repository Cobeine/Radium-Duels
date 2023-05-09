package me.cobeine.radiumduels.spigot.impl.utils.records.stats;

import me.cobeine.radiumduels.spigot.impl.utils.records.StatsRecord;
import me.cobeine.radiumduels.statistics.record.AbstractRecord;
import me.cobeine.radiumduels.statistics.record.ApplicableEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class KillsRecord extends AbstractRecord implements ApplicableEvent<PlayerDeathEvent> {


    public KillsRecord() {
        super(StatsRecord.DEATHS);
    }

    @Override
    public boolean apply(PlayerDeathEvent event) {
        return false;
    }
}
