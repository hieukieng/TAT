package database;

import java.sql.SQLException;
import java.util.HashSet;
import news.Article;
import news.Article24hComVn;
import news.ArticleBaoGiaoThongVn;
import news.ArticleTinTucVn;
import news.ArticleZingVn;
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

        StoreInfo storeInfo = new StoreInfo();

        GetLinksFromUrl getLinksFromUrl = new GetLinksFromUrl();
        
        Article article;
        
         HashSet<String> links;
         
        //trang TinTucVn
        article = new ArticleTinTucVn();

        links = getLinksFromUrl.tinTucVn(1, 50);

        try {
            storeInfo.storeInfo(article, links);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //trang 24h.com.vn
        article = new Article24hComVn();

        links = getLinksFromUrl.website24h();

        try {
            storeInfo.storeInfo(article, links);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //trang baogiaothong.vn
        article = new ArticleBaoGiaoThongVn();

        links = getLinksFromUrl.baoGiaoThongVn(1, 20);

        try {
            storeInfo.storeInfo(article, links);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        //trang zing.vn
        article = new ArticleZingVn();

        links = getLinksFromUrl.zingVn(1, 15);

        try {
            storeInfo.storeInfo(article, links);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
