package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HAVIETTRANG
 */
public class TrafficAccident {
    public static final String url = "jdbc:mysql://localhost:3306/traffic_accident";
//    private static final String url = "jdbc:mysql://localhost:3306/sakila";
    public static final String driver = "com.mysql.jdbc.Driver";
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }
    
    public void connectToDB() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, "root", "mysqldatabase");
            System.out.println("Connect success");
        } catch (Exception e) {
            System.out.println("Error connection");
            e.printStackTrace();
        }
    }
    
    public void disconnectToDB() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(TrafficAccident.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
