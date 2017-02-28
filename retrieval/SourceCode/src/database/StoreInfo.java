package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import news.Article;

/**
 *
 * @author HAVIETTRANG
 */
public class StoreInfo {

    private static final String IMAGE_URL
            = "https://s-media-cache-ak0.pinimg.com/564x/69/2b/7f/692b7fdec925793d38b4dd90ffb6e384.jpg";
    private TrafficAccident trafficAccident;
    private Connection connection;
    private PreparedStatement preSta;
    private Statement statement;
    private String query;
    private static int alreadyExists, successes;

    public StoreInfo() {

        trafficAccident = new TrafficAccident();

        trafficAccident.connectToDatabase();

        connection = trafficAccident.getConnection();
        alreadyExists = successes = 0;
    }

    /**
     * Lưu thông tin của một bài viết vào cơ sở dữ liệu
     * @param <E> Bài viết phải là một trong các kiểu dữ liệu
     * kế thừa từ abstract class {@link news.Article}
     * @param article bài viết cần lưu
     * @throws SQLException nếu xảy ra lỗi khi lưu dữ liệu vào
     * cơ sở dữ liệu
     */
    public <E extends Article> void storeInfo(E article) throws SQLException {

        String checkExist = "select id from article where source_link = '" + article.getUrl() + "'";

        statement = connection.createStatement();

        try (ResultSet rs = statement.executeQuery(checkExist)) {
            if (rs.next()) {
                System.out.println("article is exist: " + article.getUrl());
                alreadyExists++;
            } else {
                query = "insert into article (title, date, source_link, description,"
                        + "username, image_url, content)" + "values (?, ?, ?, ?, ?, ?, ?)";
                
                preSta = connection.prepareStatement(query);
                
                preSta.setString(1, article.getTitle());
                preSta.setTimestamp(2, article.getDate());
                preSta.setString(3, article.getUrl());
                preSta.setString(4, article.getDescription());
                preSta.setString(5, null);
                
                if (article.getImageUrl() != null) {
                    preSta.setString(6, article.getImageUrl());
                } else {
                    preSta.setString(6, IMAGE_URL);
                }
                
                preSta.setString(7, article.getContent());
                
                preSta.executeUpdate();
                successes++;
            }
        }
    }

    /**
     * Đóng toàn bộ kết nối gồm {@link java.sql.PreparedStatement} và
     * kết nối đến cơ sở dữ liệu {@link java.sql.Connection}
     */
    public void stop() {
        try {
            preSta.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            trafficAccident.disconnectToDatabase();
            System.out.println(alreadyExists + " articles already exist.");
            System.out.println(successes + " articles are stored successfully.");
        }
    }

    /**
     * Lưu thông tin của nhiều bài viết vào cơ sở dữ liệu
     * @param <E> Bài viết phải là một trong các kiểu dữ liệu
     * kế thừa từ abstract class {@link news.Article}
     * @param <T> Danh sách các bài viết lưu trong kiểu dữ liệu kế
     * thừa từ lớp {@link java.util.Collection}
     * @param article kiểu bài viết cần lưu
     * @param links tập hợp các bài viết
     * @throws SQLException SQLException nếu xảy ra lỗi khi lưu dữ liệu vào
     * cơ sở dữ liệu
     */
    public <E extends Article, T extends Collection> void storeInfo(E article, T links) throws SQLException {

        for (Iterator iterator = links.iterator(); iterator.hasNext();) {
            String url = (String) iterator.next();
            article.parseUrl(url);

            try {
                storeInfo(article);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
