package database;

import news.Article;
import news.ArticleZingVn;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 13, 2016 12:16:45 AM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class TestWebsite {

    private static final String URL = "http://news.zing.vn/ha-noi-thi-diem-thu-phi-do-xe-theo-gio-post696781.html";

    public static final String RSS_TIN_TUC_VN = "http://tintuc.vn/rss/giao-thong.rss";

    public static void main(String[] args) {
//        ArrayList<String> links = null;
//
//        try {
//            links = RSSReader.getAllLink(RSS_TIN_TUC_VN);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        for (Iterator<String> iterator = links.iterator(); iterator.hasNext();) {
//            String url = iterator.next();
//
//            Article article = new ArticleTinTucVn();
//
//            article.parseUrl(url);
//
//            article.parseContent(url);
//
//            System.out.println(article.getTitle());
//            System.out.println(article.getDate());
//            System.out.println(article.getDescription());
//            System.out.println(article.getImageUrl());
//            System.out.println(article.getUrl());
//            System.out.println(article.getContent());
//        }

        Article article = new ArticleZingVn();

        article.parseUrl(URL);

        article.parseContent(URL);

        System.out.println(article.getTitle());
        System.out.println(article.getDate());
        System.out.println(article.getDescription());
        System.out.println(article.getImageUrl());
        System.out.println(article.getUrl());
        System.out.println(article.getContent());
    }
}
