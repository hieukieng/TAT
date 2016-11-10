package database;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import rssfeeds.RSSReader;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 10, 2016 3:01:58 PM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class Main {

    private static final String RSS_TIN_TUC_VN = "http://tintuc.vn/rss/giao-thong.rss";

    public static void main(String[] args) throws Exception {
        ArrayList<String> rssLinks = null;

        rssLinks.add(RSS_TIN_TUC_VN);

        ArrayList<URL> links;

        StoreInfo storeInfo = new StoreInfo();

        for (int i = 0; i < rssLinks.size(); i++) {

            links = RSSReader.getAllLink(rssLinks.get(i));

            for (Iterator iterator = links.iterator(); iterator.hasNext();) {
                URL url = (URL) iterator.next();

                storeInfo.storeInfo(url);
            }
        }
    }
}
