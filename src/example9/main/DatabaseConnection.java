package example9.main;

import example8.main.Invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a very naive database connection class.
 * In real life, you should make use of a decent database API,
 * such as Spring Data or Hibernate.
 */
public class DatabaseConnection implements IDatabase {


    private static Connection connection;

    public DatabaseConnection() {
        if (connection != null) return;

        withSql(() -> {

            connection = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb.db", "SA", "");
            try (var preparedStatement = connection.prepareStatement("create table if not exists team_score (name int, value double)")) {
                preparedStatement.execute();
                connection.commit();
            }
            return null;
        });
    }

    public Connection getConnection() {
        return connection;
    }

    public void resetDatabase() {
        withSql(() -> {
            connection = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb.db", "SA", "");
            try (var preparedStatement = connection.prepareStatement("delete from team_score")) {
                preparedStatement.execute();
                connection.commit();
            }
            return null;
        });
    }

    public interface SqlSupplier<T> {
        T doSql() throws SQLException;
    }

    public <T> T withSql(SqlSupplier<T> sqlSupplier) {
        try {
            return sqlSupplier.doSql();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void close() {
        withSql(() -> {
            if (connection != null) {
                connection.close();
            }
            return null;
        });
        connection = null;
    }
    public void updateScores(String teamId, int totalScores) {
        withSql(() -> {
            try (var ps = connection.prepareStatement("insert into team_score (team_id, value) values (?,?)")) {
                ps.setString(1, teamId);
                ps.setInt(2, totalScores);
                ps.execute();

                connection.commit();
            }
            return null;
        });
    }

}
