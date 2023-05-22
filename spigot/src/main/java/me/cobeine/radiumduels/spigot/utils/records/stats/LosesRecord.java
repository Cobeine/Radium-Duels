package me.cobeine.radiumduels.spigot.utils.records.stats;

import me.cobeine.radiumduels.spigot.utils.records.StatsRecord;
import me.cobeine.radiumduels.statistics.record.AbstractRecord;
import me.cobeine.radiumduels.statistics.record.ApplicableEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class LosesRecord extends AbstractRecord implements ApplicableEvent<PlayerDeathEvent> {


    public LosesRecord() {
        super(StatsRecord.LOSES);
    }

    @Override
    public boolean apply(PlayerDeathEvent event) {
        return false;
    }
}
