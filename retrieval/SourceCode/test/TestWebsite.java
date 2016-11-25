

import news.Article;
import news.ArticleBaoGiaoThongVn;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 13, 2016 12:16:45 AM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class TestWebsite {

    private static final String URL = "http://www.atgt.vn/va-cham-o-to-tai-xe-khach-lao-thang-vao-cho-ven-duong-d177978.html";

    public static final String RSS_TIN_TUC_VN = "http://tintuc.vn/rss/giao-thong.rss";

    public static void main(String[] args) {
//        HashSet<String> links = new GetLinksFromUrl().getLinksFromTinTucVn(1, 174);
//
//        for (Iterator<String> iterator = links.iterator(); iterator.hasNext();) {
//            String url = iterator.next();
//
//            Article article = new ArticleTinTucVn();
//
//            article.parseUrl(url);
//
//            System.out.println(article.getTitle());
//            System.out.println(article.getDate());
//            System.out.println(article.getDescription());
//            System.out.println(article.getImageUrl());
//            System.out.println(article.getUrl());
//            System.out.println(article.getContent());
//        }

        Article article = new ArticleBaoGiaoThongVn();

        article.parseUrl(URL);

        System.out.println(article.getTitle());
        System.out.println(article.getDate());
        System.out.println(article.getDescription());
        System.out.println(article.getImageUrl());
        System.out.println(article.getUrl());
        System.out.println(article.getContent());
    }
}
