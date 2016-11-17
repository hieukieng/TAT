package database;

import java.sql.SQLException;
import java.util.HashSet;
import news.Article;
import news.ArticleTinTucVn;
import rssfeeds.GetLinksFromUrl;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 10, 2016 3:01:58 PM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class Main {

    public static final String RSS_TIN_TUC_VN = "http://tintuc.vn/rss/giao-thong.rss";

    public static void main(String[] args) {
        Article article = new ArticleTinTucVn();

        StoreInfo storeInfo = new StoreInfo();

        GetLinksFromUrl getLinksFromUrl = new GetLinksFromUrl();
        
//            ArrayList<String> linksRss = null;
//
//            try {
//                linksRss = RSSReader.getAllLink(RSS_TIN_TUC_VN);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//            try {
//                storeInfo.storeArticles(article, linksRss);
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }

        HashSet<String> links = getLinksFromUrl.getLinksFromTinTucVn(100, 174);

        try {
            storeInfo.storeInfo(article, links);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
