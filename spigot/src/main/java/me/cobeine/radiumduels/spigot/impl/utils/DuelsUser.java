package me.cobeine.radiumduels.spigot.impl.utils;

import lombok.Getter;
import lombok.Setter;
import me.cobeine.radiumduels.spigot.impl.utils.records.UserMatchRecord;
import me.cobeine.radiumduels.spigot.impl.utils.records.UserStatsRecord;
import me.cobeine.radiumduels.statistics.AbstractRecordPool;
import me.cobeine.radiumduels.statistics.record.AbstractRecord;
import me.cobeine.radiumduels.user.Contender;
import me.cobeine.radiumduels.user.User;
import me.cobeine.radiumduels.user.UserState;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
public class DuelsUser implements User {
    private @Setter int id;
    private final String name;
    private final UUID uniqueID;
    private final AbstractRecordPool statistics;
    private @Setter UserState userState;

    public DuelsUser(@NotNull Player player) {
        this(player.getUniqueId(), player.getName());
    }

    public DuelsUser(@NotNull UUID uuid, @Nullable String name) {
        this.name = name;
        this.uniqueID = uuid;
        this.statistics = new UserStatsRecord();
    }

    @Override
    public void acceptRecordPool(AbstractRecordPool recordPool) {//applied when a player wins a match or something
        for (AbstractRecord record : statistics.getALL()) {
            if (recordPool.getRecord(record.getKey()).isPresent()) {
                record.increment(recordPool.getRecord(record.getKey()).get().getValue());
            }
        }
    }

    @Override
    public Contender createNewContender() {
        return new DuelsContender(getName(), getUniqueID(), new UserMatchRecord(), this);
    }

}
