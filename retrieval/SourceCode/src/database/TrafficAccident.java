package database;

import java.sql.*;

/**
 *
 * @author HAVIETTRANG
 */
public class TrafficAccident {
    public static final String DATABASE = "jdbc:mysql://localhost:3306/traffic_accident";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysqldatabase";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    
    public void connectToDatabase() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
            System.out.println("Connect success");
        } catch (ClassNotFoundException e) {
            System.out.println("Database not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connecting to the database unsuccessful");
            e.printStackTrace();
        }
    }
    
    public void disconnectToDatabase() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
