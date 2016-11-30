package rssfeeds;

import database.TrafficAccident;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 27, 2016 8:52:08 PM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class GetLinksFromDatabase {

    private static TrafficAccident trafficAccident = new TrafficAccident();
    private static Statement statement;

    public static ArrayList<String> website(String query) throws SQLException {
        ArrayList<String> links = new ArrayList<>();
        
        trafficAccident.connectToDatabase();

        statement = trafficAccident.getConnection().createStatement();

        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            links.add(rs.getString(1));
        }

        return links;
    }

    private static ArrayList<String> website24hComVn() {
        String query = "select source_link from article where source_link like \"%24h.com.vn%\"";
        
        ArrayList<String> links = null;
        try {
            links = website(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return links;
    }
    
    private static ArrayList<String> websiteBaoGiaoThongVn() {
        String query = "select source_link from article where source_link like \"%baogiaothong.vn%\"";
        
        ArrayList<String> links = null;
        try {
            links = website(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return links;
    }
    
    private static ArrayList<String> websiteTinTucVn() {
        String query = "select source_link from article where source_link like \"%tintuc.vn%\"";
        
        ArrayList<String> links = null;
        try {
            links = website(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return links;
    }
    
    private static ArrayList<String> websiteZingVn() {
        String query = "select source_link from article where source_link like \"%zing.vn%\"";
        
        ArrayList<String> links = null;
        try {
            links = website(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return links;
    }
    
}
