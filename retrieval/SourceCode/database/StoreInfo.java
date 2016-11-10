package database;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import news.Article;

/**
 *
 * @author HAVIETTRANG
 */
public class StoreInfo {

    private TrafficAccident trafficAccident;
    private PreparedStatement preSta;
    private Article article;
    private String query;

    public StoreInfo() {
        trafficAccident = new TrafficAccident();
    }

    public void storeInfo(URL url) throws SQLException {

        trafficAccident.connectToDatabase();

        article.parseUrl(url);

        query = "insert into article (title, date, source_link, description, username, avatar, content)" + "values (?, ?, ?, ?, ?, ?, ?)";

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

}
