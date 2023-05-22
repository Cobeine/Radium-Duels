package me.cobeine.radiumduels.spigot.storage.mysql.tables;

import me.cobeine.sqllava.table.Table;
import me.cobeine.sqllava.table.column.Column;
import me.cobeine.sqllava.table.column.ColumnSettings;
import me.cobeine.sqllava.table.column.ColumnType;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class PlayerSavedKitsTable extends Table {


    public PlayerSavedKitsTable() {
        super("settings");
        addColumns(
                Column.of("uuid", ColumnType.VARCHAR).size(128).settings(ColumnSettings.NOT_NULL, ColumnSettings.UNIQUE),
                Column.of("gamemode_id", ColumnType.INT),
                Column.of("setting_value", ColumnType.LONGTEXT).defaultValue("{}")
        );
        setPrimaryKey("uuid");
    }
}
