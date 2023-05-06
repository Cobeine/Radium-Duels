package me.cobeine.radiumduels.storage.mysql.queries;


import me.cobeine.radiumduels.storage.mysql.MySQLConnection;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

@SuppressWarnings("unused")
public class Query {

    private final MySQLConnection mysql;
    private final Connection connection;
    private final PreparedStatement statement;

    public Query(MySQLConnection mysql, String sql) throws SQLException {
        this.mysql = mysql;
        this.connection = mysql.getConnection();
        this.statement = connection.prepareStatement(sql);
    }

    public void setParameter(int index, Object value) {
        try {
            if (statement == null)
                return;
            statement.setObject(index, value);
        } catch (Exception ignored) {
        }
    }

    public int[] executeBatch() throws SQLException {
        try {
            return statement.executeBatch();
        } finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.commit();
                connection.close();
            }
        }
    }

    public void executeBatchAsync() {
        executeBatchAsync(null);
    }

    public void executeBatchAsync(final Callback<int[], SQLException> callback) {
        mysql.getThreadPool().submit(() -> {
            try {
                int[] rowsChanged = executeBatch();
                if (callback != null) {
                    callback.call(rowsChanged, null);
                }
            } catch (SQLException e) {
                if (callback != null) {
                    callback.call(null, e);
                }
            }
        });
    }

    public int executeUpdate() throws SQLException {
        try {
            return statement.executeUpdate();

        } finally {

            if (statement != null && !statement.isClosed())
                statement.close();

            if (connection != null)
                connection.close();

        }
    }

    public int executeUpdateWithKeys() throws SQLException {
        try {
            String stm = statement.toString();
            String sql = stm.substring(stm.indexOf("INSERT"));
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet == null || !resultSet.next())
                return 0;
            return resultSet.getInt(1);
        } finally {

            if (statement != null)
                statement.close();

            if (connection != null)
                connection.close();

        }
    }

    public ResultSet executeQuery() throws SQLException {
        CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();

        try (ResultSet resultSet = statement.executeQuery()) {

            rowSet.populate(resultSet);

        } finally {

            if (statement != null && !statement.isClosed())
                statement.close();

            if (connection != null)
                connection.close();

        }
        return rowSet;
    }

    public void executeUpdateAsync(final Callback<Integer, SQLException> callback) {
        mysql.getThreadPool().submit(() -> {

            try {
                int rowsChanged = executeUpdate();
                if (callback != null)
                    callback.call(rowsChanged, null);

            } catch (SQLException e) {
                if (callback != null)
                    callback.call(0, e);
                else
                    e.printStackTrace();
            }
        });
    }
    public void addBatch() throws SQLException {
        if (connection.getAutoCommit()) {
            connection.setAutoCommit(false);
        }
        statement.addBatch();
    }

    public void addBatch(String s) throws SQLException {
        statement.addBatch(s);
    }

    public void executeUpdateAsyncWithGeneratedKeys( Callback<Integer, SQLException> callback) {
        mysql.getThreadPool().submit(() -> {

            try {
                int id = executeUpdateWithKeys();
                if (callback != null)
                    callback.call(id, null);

            } catch (SQLException e) {
                if (callback != null)
                    callback.call(0, e);
                else
                    e.printStackTrace();
            }
        });
    }

    public void executeUpdateAsync() {
        executeUpdateAsync(null);
    }
    public void executeQueryAsync(final Callback<ResultSet, SQLException> callback) {
        mysql.getThreadPool().submit(() -> {
            try {
                ResultSet rs = executeQuery();
                callback.call(rs, null);
            } catch (SQLException e) {
                callback.call(null, e);
            }
        });
    }
    @SuppressWarnings("unused")
    public void rollback() throws SQLException {
        if (connection != null)
            connection.rollback();
    }
}
