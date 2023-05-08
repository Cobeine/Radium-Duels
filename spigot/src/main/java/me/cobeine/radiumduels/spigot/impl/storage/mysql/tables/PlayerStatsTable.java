package me.cobeine.radiumduels.spigot.impl.storage.mysql.tables;

import me.cobeine.sqllava.table.Table;
import me.cobeine.sqllava.table.column.Column;
import me.cobeine.sqllava.table.column.ColumnSettings;
import me.cobeine.sqllava.table.column.ColumnType;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class PlayerStatsTable extends Table {

    public PlayerStatsTable() {
        super("stats");
        addColumns(
                Column.of("id", ColumnType.INT).settings(ColumnSettings.AUTO_INCREMENT),
                Column.of("uuid", ColumnType.VARCHAR).size(64).settings(ColumnSettings.NOT_NULL),
                Column.of("name", ColumnType.VARCHAR).size(128).defaultValue("nani").settings(ColumnSettings.NOT_NULL),
                Column.of("lifetime_kills", ColumnType.INT),
                Column.of("lifetime_deaths", ColumnType.INT),
                Column.of("lifetime_wins", ColumnType.INT),
                Column.of("lifetime_loses", ColumnType.INT),
                Column.of("lifetime_total_matches", ColumnType.INT)
        );
        setPrimaryKey("id");
    }


}
