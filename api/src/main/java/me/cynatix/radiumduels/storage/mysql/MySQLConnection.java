package me.cynatix.radiumduels.storage.mysql;

import com.zaxxer.hikari.HikariDataSource;
import me.cynatix.radiumduels.storage.mysql.queries.Callback;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface MySQLConnection {

    default void createTables(){};

    void openConnection(Callback<Integer,Throwable> result) throws ClassNotFoundException;

    ExecutorService getThreadPool();

    HikariDataSource getDataSource();

    Credentials getCredentials();


    default boolean isClosed() {
        return getDataSource() == null || getDataSource().isClosed();
    }
    default Connection getConnection() {
        if (isClosed())
            throw new IllegalStateException("Connection is not open.");

        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    default void close() {
        if (isClosed())
            return;

        getDataSource().close();
        getThreadPool().shutdown();
    }
    default void disableLogging() {
        Logger.getLogger("com.zaxxer.hikari.pool.PoolBase").setLevel(Level.OFF);
        Logger.getLogger("com.zaxxer.hikari.pool.HikariPool").setLevel(Level.OFF);
        Logger.getLogger("com.zaxxer.hikari.HikariDataSource").setLevel(Level.OFF);
        Logger.getLogger("com.zaxxer.hikari.HikariConfig").setLevel(Level.OFF);
        Logger.getLogger("com.zaxxer.hikari.util.DriverDataSource").setLevel(Level.OFF);
    }

}
