package me.cobeine.radiumduels.spigot.managers;

import lombok.AllArgsConstructor;
import me.cobeine.radiumduels.spigot.Core;
import me.cobeine.radiumduels.spigot.storage.mysql.MySQLConnection;
import me.cobeine.radiumduels.spigot.utils.DuelsUser;
import me.cobeine.radiumduels.spigot.utils.records.StatsRecord;
import me.cobeine.sqllava.query.Query;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@AllArgsConstructor
public class MySQLManager {

    public final String users, settings, kits;
    private final MySQLConnection connection;


    public void loadUser(DuelsUser user) {

        connection.prepareStatement(Query.select(users).column(StatsRecord.asStringArray()).where("uuid", user.getUniqueID().toString()))
                .executeQueryAsync((result, throwable) -> {
                    try (result) {
                        if (throwable != null) throw throwable;

                        if (!result.next()) {//User not found
                            createUser(user);
                            return;
                        }
                        for (StatsRecord statsRecord : StatsRecord.values()) {
                            int value = result.getInt(statsRecord.name().toLowerCase());
                            user.getStatistics().getRecord(statsRecord).ifPresent(e -> e.increment(value));
                        }

                    } catch (Exception e) {
                        connection.getLogger().severe("Failed to load user '" + user.getUniqueID() + "': " + e);
                    }
                });

    }

    private void createUser(DuelsUser user) {
        try {
            int userID = connection.prepareStatement(Query.insert(users).set("uuid").set("name").set("kills").set("deaths").set("wins").set("loses").set("matches").set("elo"))
                    .setParameter(1, user.getUniqueID())
                    .setParameter(2, user.getName())
                    .setParameter(3,0)
                    .setParameter(4,0)
                    .setParameter(5,0)
                    .setParameter(6,0)
                    .setParameter(7,0)
                    .setParameter(8,0)
                    .executeUpdateWithKeys();
            Core.getInstance().getUserManager().addUser(user);
            user.setId(userID);
        }catch (Exception e){
            connection.getLogger().severe("Failed to create user '" + user.getUniqueID() + "': " + e);
        }

    }

    public static MySQLManager getInstance() {
        return Core.getInstance().getMySQLConnection().getSqlManager();
    }

}
