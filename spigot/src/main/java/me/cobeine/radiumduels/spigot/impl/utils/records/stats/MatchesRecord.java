package me.cobeine.radiumduels.spigot.impl.utils.records.stats;

import me.cobeine.radiumduels.spigot.impl.utils.records.StatsRecord;
import me.cobeine.radiumduels.statistics.record.AbstractRecord;
import me.cobeine.radiumduels.statistics.record.ApplicableEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class MatchesRecord extends AbstractRecord implements ApplicableEvent<PlayerDeathEvent> {


    public MatchesRecord() {
        super(StatsRecord.MATCHES);
    }

    @Override
    public boolean apply(PlayerDeathEvent event) {
        return false;
    }
}
