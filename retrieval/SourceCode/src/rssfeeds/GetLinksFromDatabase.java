package rssfeeds;

import database.TrafficAccident;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 27, 2016 8:52:08 PM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class GetLinksFromDatabase {

    private static TrafficAccident trafficAccident = new TrafficAccident();
    private static Statement statement;

    private static HashSet<String> website(String query) throws SQLException {
        HashSet<String> links = new HashSet<>();
        
        trafficAccident.connectToDatabase();

        statement = trafficAccident.getConnection().createStatement();

        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            links.add(rs.getString(1));
        }

        return links;
    }

    public static HashSet<String> website24hComVn() {
        String query = "select source_link from article where source_link like \"%24h.com.vn%\"";
        
        HashSet<String> links = null;
        try {
            links = website(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return links;
    }
    
    public static HashSet<String> websiteBaoGiaoThongVn() {
        String query = "select source_link from article where source_link like \"%baogiaothong.vn%\"";
        
        HashSet<String> links = null;
        try {
            links = website(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return links;
    }
    
    public static HashSet<String> websiteTinTucVn() {
        String query = "select source_link from article where source_link like \"%tintuc.vn%\"";
        
        HashSet<String> links = null;
        try {
            links = website(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return links;
    }
    
    public static HashSet<String> websiteZingVn() {
        String query = "select source_link from article where source_link like \"%zing.vn%\"";
        
        HashSet<String> links = null;
        try {
            links = website(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return links;
    }
    
}
