

import java.util.ArrayList;
import java.util.Iterator;
import news.Article;
import news.ArticleTinTucVn;
import rssfeeds.RSSReader;

/**
 * @date Oct 17, 2016 4:09:52 PM
 * @author HAVIETTRANG
 * @website haviettrang.blogspot.com
 */
public class TestRss {

    public static void main(String[] args) throws Exception {
        String rssLink = "http://tintuc.vn/rss/giao-thong.rss";
        
        ArrayList<String> links = null;
        
        String url;
        
        Article article;

        try {
            links = RSSReader.getAllLink(rssLink);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        for (Iterator iterator = links.iterator(); iterator.hasNext();) {
            
            article = new ArticleTinTucVn();
            
            url = (String) iterator.next();
            
            article.parseUrl(url);

            System.out.println(article.getTitle());
            System.out.println(article.getUrl());
            System.out.println(article.getDate());
            System.out.println(article.getDescription());
            System.out.println(article.getImageUrl());
            System.out.println(article.getContent());
        }
    }
}
