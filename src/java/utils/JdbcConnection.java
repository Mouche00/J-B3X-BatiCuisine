package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class JdbcConnection {

    public static Optional<Connection> connection = Optional.empty();

    public static Optional<Connection> getConnection() {
        if(!connection.isPresent()) {
            String url = "jdbc:postgresql://localhost:5432/bati_cuisine";
            String user = "root";
            String password = "root";

            try {
                connection = Optional.ofNullable(
                        DriverManager.getConnection(url, user, password));
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        }

        return connection;
    }

}
