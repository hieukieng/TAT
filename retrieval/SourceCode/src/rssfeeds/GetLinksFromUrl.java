package rssfeeds;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 13, 2016 4:08:32 PM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class GetLinksFromUrl {

    public static final String WEBSITE_24H_COM_VN = "http://www.24h.com.vn/tai-nan-giao-thong-c408.html";
    public static final String BAO_GIAO_THONG_VN = "http://www.baogiaothong.vn/tin-tuc-tai-nan-giao-thong-moi-nhat-trong-ngay--hinh-anh-video-clip-tngt-channel30/";
    public static final String NEWS_ZING_VN = "http://news.zing.vn/giao-thong.html";
    public static final String EVA_VN = "http://eva.vn/tai-nan-giao-thong-moi-nhat-p1375c73.html";

    private Document document;
    Elements elements;
    Iterator<Element> iterator;

    public GetLinksFromUrl() {
    }
    
    private void connectUrl(String url) {
        try {
            document = Jsoup.connect(url).timeout(10000).userAgent("Chrome").get();
        } catch (IOException ex) {
            System.out.println("Can't connect to website " + url);
            ex.printStackTrace();
        }
    }

    public HashSet<String> getLinksFrom24h() {
        connectUrl(WEBSITE_24H_COM_VN);

        HashSet<String> links = new HashSet<>();

        elements = document.select("a[href]");
        iterator = elements.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next().attr("href");
            if (s.contains("/tai-nan-giao-thong/")) {
                if (!s.contains("24h.com.vn")) {
                    s = "http://www.24h.com.vn" + s;
                }
                links.add(s);
            }
        }
        return links;
    }
    
    /**
     * Get all article from 
     * "http://tintuc.vn/giao-thong?page=<b>pageBegin<b>" to
     * "http://tintuc.vn/giao-thong?page=<b>pageEnd<b>
     * @param pageBegin
     * @param pageEnd
     * @return 
     */
    public HashSet<String> getLinksFromTinTucVn(int pageBegin, int pageEnd) {
        String url = "http://tintuc.vn/giao-thong?page=";
        connectUrl(WEBSITE_24H_COM_VN);

        HashSet<String> links = new HashSet<>();

        elements = document.select("a[href]");
        iterator = elements.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next().attr("href");
            if (s.contains("/tai-nan-giao-thong/")) {
                if (!s.contains("24h.com.vn")) {
                    s = "http://www.24h.com.vn" + s;
                }
                links.add(s);
            }
        }
        return links;
    }

    //chua hoan thien
    public HashSet<String> getLinksFromZing() {
        connectUrl(NEWS_ZING_VN);

        HashSet<String> links = new HashSet<>();

        elements = document.select("a[href]");
        iterator = elements.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next().attr("href");
//            if (s.contains("news.zing.vn/")) {
//                if (!s.contains("24h.com.vn")) {
//                    s = "http://www.24h.com.vn" + s;
//                    links.add(s);
//                }
            links.add(s);
            System.out.println(s);
//            }
        }
        return links;
    }

    public HashSet<String> getLinksFromEva() {
        connectUrl(EVA_VN);

        HashSet<String> links = new HashSet<>();

        elements = document.select("a[href]");
        iterator = elements.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next().attr("href");
            if (s.contains("/tin-tuc/")) {
                if (!s.contains("tai-nan-giao-thong-moi-nhat") && !s.contains("eva.vn/")) {
                    s = "http://eva.vn" + s;
                    links.add(s);
                }
            }
        }
        return links;
    }

//    public static void main(String[] args) {
//        GetLinksFromUrl demo = new GetLinksFromUrl();
//
//        Iterator i = demo.getAllLinksFromZing().iterator();
//        
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }
//    }
}
