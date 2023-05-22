package me.cobeine.radiumduels.spigot.storage.mysql.tables;

import me.cobeine.sqllava.table.Table;
import me.cobeine.sqllava.table.column.Column;
import me.cobeine.sqllava.table.column.ColumnSettings;
import me.cobeine.sqllava.table.column.ColumnType;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class PlayerSettingsTable extends Table {


    public PlayerSettingsTable() {
        super("settings");
        addColumns(
                Column.of("uuid", ColumnType.VARCHAR).size(128).settings(ColumnSettings.NOT_NULL, ColumnSettings.UNIQUE),
                Column.of("setting_id", ColumnType.INT),
                Column.of("setting_value", ColumnType.INT).defaultValue("0")
        );
        setPrimaryKey("uuid");
    }
}
