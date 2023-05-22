package me.cobeine.radiumduels.spigot.utils.records.stats;

import me.cobeine.radiumduels.spigot.utils.records.StatsRecord;
import me.cobeine.radiumduels.statistics.record.AbstractRecord;
import me.cobeine.radiumduels.statistics.record.ApplicableEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class WinsRecord extends AbstractRecord implements ApplicableEvent<PlayerDeathEvent> {


    public WinsRecord() {
        super(StatsRecord.WINS);
    }

    @Override
    public boolean apply(PlayerDeathEvent event) {
        return false;
    }
}
