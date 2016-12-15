package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class kết nối dến cơ sở dữ liệu, database mặc định ở đây
 * là <b>localhost</b>, cổng <b>3306</b>, tên cơ sở dữ liệu <b>traffic_accident</b>,
 *  username <b>root</b> và password là <b>mysqldatabase</b>
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
    
    /**
     * Kết nối đến database
     */
    public void connectToDatabase() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
            System.out.println("Connecting to database successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Database not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connecting to the database unsuccessfully");
            e.printStackTrace();
        }
    }
    /**
     * ngắt kết nối đến database
     */
    public void disconnectToDatabase() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
