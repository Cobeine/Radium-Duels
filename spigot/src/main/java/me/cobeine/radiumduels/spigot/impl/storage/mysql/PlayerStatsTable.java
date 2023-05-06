package me.cobeine.radiumduels.spigot.impl.storage.mysql;

import me.cobeine.radiumduels.storage.mysql.column.Column;
import me.cobeine.radiumduels.storage.mysql.column.ColumnSettings;
import me.cobeine.radiumduels.storage.mysql.column.ColumnType;
import me.cobeine.radiumduels.storage.mysql.table.Table;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class PlayerStatsTable extends Table {

    public PlayerStatsTable(String name) {
        super(name);
        Column id = Column.of("id", ColumnType.INT).settings(ColumnSettings.AUTO_INCREMENT);
        addColumns(
                id,
                Column.of("uuid", ColumnType.VARCHAR).size(64).settings(ColumnSettings.NOT_NULL),
                Column.of("name", ColumnType.VARCHAR).size(128).defaultValue("nan").settings(ColumnSettings.NOT_NULL),
                Column.of("lifetime_kills", ColumnType.INT),
                Column.of("lifetime_deaths", ColumnType.INT),
                Column.of("lifetime_wins", ColumnType.INT),
                Column.of("lifetime_loses", ColumnType.INT),
                Column.of("lifetime_total_matches", ColumnType.INT)
        );
        setPrimaryKey(id);
        System.out.println(this);
    }

}
