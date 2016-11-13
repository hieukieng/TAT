package database;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import news.Article;
import news.ArticleTinTucVn;
import rssfeeds.RSSReader;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 10, 2016 3:01:58 PM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class Main {

    private static final String RSS_TIN_TUC_VN = "http://tintuc.vn/rss/giao-thong.rss";
    private static final String BAO_GIAO_THONG_VN = "http://www.baogiaothong.vn/tin-tuc-tai-nan-giao-thong-moi-nhat-trong-ngay--hinh-anh-video-clip-tngt-channel30/";
    private static final String WEBSITE_24_COM_VN = "http://www.24h.com.vn/tai-nan-giao-thong-c408.html";
    private static final String NEWS_ZING_VN = "http://news.zing.vn/giao-thong.html";
    private static final String EVA_VN = "http://eva.vn/tai-nan-giao-thong-moi-nhat-p1375c73.html";

    public static void main(String[] args) throws Exception {
        Article article = new ArticleTinTucVn();
        
        StoreInfo storeInfo = new StoreInfo();
        
        ArrayList<String> links;

        links = RSSReader.getAllLink(RSS_TIN_TUC_VN);

        for (Iterator iterator = links.iterator(); iterator.hasNext();) {
            URL url = (URL) iterator.next();

            storeInfo.storeInfo(article);
        }
    }
}
