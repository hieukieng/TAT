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
        if (article.getImageUrl() != null) {
            preSta.setString(6, article.getImageUrl());
        } else {
            preSta.setString(6, "https://s-media-cache-ak0.pinimg.com/564x/69/2b/7f/692b7fdec925793d38b4dd90ffb6e384.jpg");
        }
        
        preSta.setString(7, article.getContent());

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
