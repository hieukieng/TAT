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
    public static void main(String[] args) {
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
