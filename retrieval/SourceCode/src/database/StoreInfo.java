package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import news.Article;

/**
 *
 * @author HAVIETTRANG
 */
public class StoreInfo {

    private TrafficAccident trafficAccident;
    private PreparedStatement preSta;
    private String query;

    public StoreInfo() {
        trafficAccident = new TrafficAccident();
    }

    public <E extends Article> void storeInfo(E article) throws SQLException {

        trafficAccident.connectToDatabase();

        query = "insert into article (title, date, source_link, description, username, image_url, content)" + "values (?, ?, ?, ?, ?, ?, ?)";

        preSta = trafficAccident.getConnection().prepareStatement(query);

        preSta.setString(1, article.getTitle());
        preSta.setTimestamp(2, article.getDate());
        preSta.setString(3, article.getUrl());
        preSta.setString(4, article.getDescription());
        preSta.setString(5, null);
        preSta.setString(6, article.getImageUrl());
        preSta.setString(7, null);

        preSta.executeUpdate();

        System.out.println("Store information successfully");
        preSta.close();
        trafficAccident.disconnectToDatabase();
    }
    
    public <E extends Article, T extends  Collection> void storeArticles(E article, T links) throws SQLException {
        
        for (Iterator iterator = links.iterator(); iterator.hasNext();) {
            article.parseUrl((String) iterator.next());

            try {
                storeInfo(article);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
