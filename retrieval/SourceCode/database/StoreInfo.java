package database;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import news.NewsContent;
import news.NewsHeader;

/**
 *
 * @author HAVIETTRANG
 */
public class StoreInfo {

    TrafficAccident trafficAccident = new TrafficAccident();
    PreparedStatement preSta;
    NewsContent newsContent = new NewsContent();
    NewsHeader newsHeader = new NewsHeader();
    String query;

    public void storeInfo(URL url) throws SQLException {
        trafficAccident.connectToDB();

//        store Information into table newContent
        newsContent.parseUrl(url);

        query = "insert into newsContent (content)" + "values (?)";
        preSta = trafficAccident.getConnection().prepareStatement(query);
        preSta.setString(1, newsContent.getContent());
        preSta.executeUpdate();

        //Store information into table newsHeader;
        newsHeader.parseUrl(url);

        query = "insert into newsHeader (newsTitle, newsDate, sourceLink, newsDescription)" + "values (?, ?, ?, ?)";
        preSta = trafficAccident.getConnection().prepareStatement(query);
        preSta.setString(1, newsHeader.getTitle());
        preSta.setTimestamp(2, newsHeader.getDate());
        preSta.setString(3, newsHeader.getUrl());
        preSta.setString(4, newsHeader.getDescription());
        preSta.executeUpdate();

        System.out.println("Store information successfully");
        preSta.close();
        trafficAccident.disconnectToDB();
    }
}
