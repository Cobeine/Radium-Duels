package me.cobeine.radiumduels.spigot.impl.managers;

import com.zaxxer.hikari.HikariDataSource;
import me.cobeine.radiumduels.storage.mysql.Credentials;
import me.cobeine.radiumduels.storage.mysql.MySQLConnection;
import me.cobeine.radiumduels.storage.mysql.queries.Callback;

import java.util.concurrent.ExecutorService;

/**
 * @author <a href="https://github.com/Cobeine">Cobeine</a>
 */

public class MySQLManager implements MySQLConnection {


    @Override
    public void openConnection(Callback<Integer, Throwable> result) throws ClassNotFoundException {

    }

    @Override
    public ExecutorService getThreadPool() {
        return null;
    }

    @Override
    public HikariDataSource getDataSource() {
        return null;
    }

    @Override
    public Credentials getCredentials() {
        return null;
    }
}
