package me.cobeine.radiumduels.spigot.storage.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import me.cobeine.radiumduels.spigot.managers.MySQLManager;
import me.cobeine.radiumduels.spigot.storage.mysql.tables.PlayerSettingsTable;
import me.cobeine.radiumduels.spigot.storage.mysql.tables.PlayerStatsTable;
import me.cobeine.sqllava.connection.Callback;
import me.cobeine.sqllava.connection.ConnectionResult;
import me.cobeine.sqllava.connection.ConnectionSource;
import me.cobeine.sqllava.connection.SQLConnection;
import me.cobeine.sqllava.query.PreparedQuery;
import me.cobeine.sqllava.table.Table;
import me.cobeine.sqllava.utils.Credentials;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */
@Getter
public class MySQLConnection implements SQLConnection {

   private final ExecutorService threadPool;
   private HikariDataSource dataSource;
   private final Credentials credentials;
   private Table stats,settings;//,kits;
   private @Getter MySQLManager sqlManager;

    public MySQLConnection(Credentials passedCredentials, int threads) throws ClassNotFoundException {
        this.credentials = passedCredentials;
        this.threadPool = Executors.newFixedThreadPool(threads);
        openConnection((result, throwable) -> {
            if (throwable == null) {
                onResult(ConnectionResult.SUCCESS);
                return;
            }
            onResult(ConnectionResult.FAIL);
            throwable.printStackTrace();
        });
    }

    @Override
    public void openConnection(Callback<Integer, Throwable> result) throws ClassNotFoundException {
      try {
          HikariConfig config = ConnectionSource.HIKARI_DATASOURCE.getBuilder().apply(credentials);
          this.dataSource = new HikariDataSource(config);
          result.call(0, null);
      }catch (Exception e){
          result.call(-1, e);
      }
    }

    @Override
    public void onResult(ConnectionResult result) {
        if (result.equals(ConnectionResult.SUCCESS)) {
            stats = new PlayerStatsTable();
         //TODO FIX   kits = new PlayerSavedKitsTable();
            settings = new PlayerSettingsTable();
            this.sqlManager = new MySQLManager(stats.getName(), null, settings.getName(),this);

            try {
                PreparedQuery statement  = this.prepareStatement(stats.toString());
                statement.addBatch();
                statement.addBatch(settings.toString());
                statement.executeBatch();
              /*  createTables((r, throwable) -> {
                    if (throwable == null) {
                        this.getLogger().info("Created sql tables successfully!");
                    }else {
                        throwable.printStackTrace();
                    }
                },stats,settings);*/
            } catch (SQLException e) {
                this.getLogger().severe("Failed to create sql tables: " + e);
            }
        }
    }


}
