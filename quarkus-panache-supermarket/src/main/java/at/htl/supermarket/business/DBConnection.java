package at.htl.supermarket.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection dbConnection;

    public void getDBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection("jdbc:postgresql://192.168.99.100:5432/postgres", "postgres", "passme");
    }

    public int executeQuery(String query) throws ClassNotFoundException, SQLException {
        return dbConnection.createStatement().executeUpdate(query);
    }
}
