package database;

import java.sql.SQLException;
import java.util.HashSet;
import news.Article;
import news.Article24hComVn;
import news.ArticleBaoGiaoThongVn;
import news.ArticleNldComVn;
import news.ArticleTinTucVn;
import news.ArticleZingVn;
import rssfeeds.GetLinksFromUrl;
import rssfeeds.RSSReader;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 10, 2016 3:01:58 PM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class Main {

    public static final String RSS_TIN_TUC_VN = "http://tintuc.vn/rss/giao-thong.rss";

    private StoreInfo storeInfo;
    private GetLinksFromUrl getLinksFromUrl;
    private Article article;
    private HashSet<String> links;

    public Main() {
        storeInfo = new StoreInfo();
        getLinksFromUrl = new GetLinksFromUrl();
        links = new HashSet<>();
    }

    /**
     * lưu một số bài viết từ 4 trang web {@link news.ArticleTinTucVn},
     * {@link news.ArticleBaoGiaoThongVn}, {@link news.Article24hComVn},
     * {@link news.ArticleZingVn}, {@link news.ArticleNldComVn}
     * 
     * @see #saveArticlesTinTucVn() 
     * @see #saveArticlesBaoGiaoThongVn() 
     * @see #saveArticle24hComVn() 
     * @see #saveArticlesZingVn() 
     * @see #saveArticleNldComVn() 
     */
    public void saveAll() {
        saveArticlesTinTucVn();
        saveArticlesBaoGiaoThongVn();
        saveArticle24hComVn();
//        saveArticlesZingVn();
        saveArticleNldComVn();
    }

    /**
     * Lấy một số lượng bài viết từ trang <a href="http://tintuc.vn/giao-thong">
     * http://tintuc.vn/giao-thong</a>
     * <p> khi truyền tham số vào trong hàm {@link rssfeeds.GetLinksFromUrl#tinTucVn(int, int) }
     * lần lượt là 1 và 10.
     */
    public void saveArticlesTinTucVn() {
        saveArticlesTinTucVn(1, 10);
    }
    /**
     * Lấy một số lượng bài viết từ trang <a href="http://tintuc.vn/giao-thong">
     * http://tintuc.vn/giao-thong</a>
     * <p> khi truyền các tham số vào trong hàm {@link rssfeeds.GetLinksFromUrl#tinTucVn(int, int) }
     * @param pageBegin tham số thứ nhất
     * @param pageEnd tham số thứ hai
     */
    public void saveArticlesTinTucVn(int pageBegin, int pageEnd) {
        article = new ArticleTinTucVn();

        links = getLinksFromUrl.tinTucVn(pageBegin, pageEnd);

        store();
    }

    /**
     * Lấy một số bài viết với URL được cung cấp bởi RSS Feed của
     * trang web <a href="http://tintuc.vn/rss/giao-thong.rss">tintuc.vn</a>
     * @param getLinksFromRSS <i>true</i> nếu muốn lưu dữ liệu với links
     * lấy từ RSS Feed, <i>false</i> nếu ngược lại.
     * @see rssfeeds.RSSReader#getAllLink(java.lang.String) 
     */
    public void saveArticlesTinTucVn(boolean getLinksFromRSS) {
        article = new ArticleTinTucVn();

        try {
            links = new HashSet<>(RSSReader.getAllLink(RSS_TIN_TUC_VN));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        store();
    }

    /**
     * Lấy một số lượng bài viết từ trang
     * <a href="http://www.baogiaothong.vn/tin-tuc-tai-nan-giao-thong-moi-nhat-trong-ngay--hinh-anh-video-clip-tngt-channel30/">
     * http://www.baogiaothong.vn/tin-tuc-tai-nan-giao-thong-moi-nhat-trong-ngay--hinh-anh-video-clip-tngt-channel30/</a>
     * <p> khi truyền tham số vào trong hàm {@link rssfeeds.GetLinksFromUrl#baoGiaoThongVn(int, int) }
     * lần lượt là 1 và 10.
     */
    public void saveArticlesBaoGiaoThongVn() {
        saveArticlesBaoGiaoThongVn(1, 5);
    }
    
    /**
     * Lấy một số lượng bài viết từ trang
     * <a href="http://www.baogiaothong.vn/tin-tuc-tai-nan-giao-thong-moi-nhat-trong-ngay--hinh-anh-video-clip-tngt-channel30/">
     * http://www.baogiaothong.vn/tin-tuc-tai-nan-giao-thong-moi-nhat-trong-ngay--hinh-anh-video-clip-tngt-channel30/</a>
     * <p> khi truyền các tham số vào trong hàm {@link rssfeeds.GetLinksFromUrl#baoGiaoThongVn(int, int) }
     * @param pageBegin tham số thứ nhất
     * @param pageEnd tham số thứ hai
     */
    public void saveArticlesBaoGiaoThongVn(int pageBegin, int pageEnd) {
        article = new ArticleBaoGiaoThongVn();

        links = getLinksFromUrl.baoGiaoThongVn(pageBegin, pageEnd);

        store();
    }

    /**
     * Lấy một số lượng bài viết từ trang <a href="http://www.24h.com.vn/tai-nan-giao-thong-c408.html">
     * http://www.24h.com.vn/tai-nan-giao-thong-c408.html</a>
     * <p> khi họi đến hàm {@link rssfeeds.GetLinksFromUrl#website24h() }
     */
    public void saveArticle24hComVn() {
        article = new Article24hComVn();

        links = getLinksFromUrl.website24h();

        store();
    }

    /**
     * Lấy một số lượng bài viết từ trang <a href="http://news.zing.vn/giao-thong.html">
     * http://news.zing.vn/giao-thong.html</a>
     * <p> khi truyền tham số vào trong hàm {@link rssfeeds.GetLinksFromUrl#zingVn(int, int)  }
     * lần lượt là 1 và 10.
     */
    public void saveArticlesZingVn() {
        saveArticlesZingVn(1, 10);
    }

    /**
     * Lấy một số lượng bài viết từ trang <a href="http://news.zing.vn/giao-thong.html">
     * http://news.zing.vn/giao-thong.html</a>
     * <p> khi truyền các tham số vào trong hàm {@link rssfeeds.GetLinksFromUrl#tinTucVn(int, int) }
     * @param pageBegin tham số thứ nhất
     * @param pageEnd tham số thứ hai
     */
    public void saveArticlesZingVn(int pageBegin, int pageEnd) {
        article = new ArticleZingVn();

        links = getLinksFromUrl.zingVn(pageBegin, pageEnd);

        store();
    }

    /**
     * lưu thông tin bài viết từ tập hợp các {@code links}
     */
    private void store() {
        try {
            storeInfo.storeInfo(article, links);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * dừng lưu thông tin
     */
    public void stop() {
        storeInfo.stop();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.saveAll();
        main.stop();
    }

    /**
     * Lấy một số lượng bài viết từ trang <a href="http://nld.com.vn/tai-nan-giao-thong.html">
     * http://nld.com.vn/tai-nan-giao-thong.html</a>
     * <p> khi truyền tham số vào trong hàm {@link rssfeeds.GetLinksFromUrl#nldComVn(int, int)  }
     * lần lượt là 1 và 10.
     */
    private void saveArticleNldComVn() {
        saveArticleNldComVn(1, 10);
    }

    /**
     * Lấy một số lượng bài viết từ trang <a href="http://nld.com.vn/tai-nan-giao-thong.html">
     * http://nld.com.vn/tai-nan-giao-thong.html</a>
     * <p> khi truyền tham số vào trong hàm {@link rssfeeds.GetLinksFromUrl#nldComVn(int, int)  }
     * @param pageBegin tham số thứ nhất
     * @param pageEnd tham số thứ hai
     */
    private void saveArticleNldComVn(int pageBegin, int pageEnd) {
        article = new ArticleNldComVn();

        links = getLinksFromUrl.nldComVn(pageBegin, pageEnd);

        store();
    }
}
