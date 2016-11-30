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

    public static final String WEBSITE_24H_COM_VN =
            "http://www.24h.com.vn/tai-nan-giao-thong-c408.html";
    public static final String BAO_GIAO_THONG_VN =
            "http://www.baogiaothong.vn/tin-tuc-tai-nan-giao-thong-moi-nhat-trong-ngay--hinh-anh-video-clip-tngt-channel30/";
    public static final String NEWS_ZING_VN ="http://news.zing.vn/giao-thong.html";

    private Document document;
    private Elements elements;
    private Iterator<Element> iterator;

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
    
    /**
     * 
     * @return Các links về mục tai nạn giao thông tại trang
     * <a href="http://www.24h.com.vn/tai-nan-giao-thong-c408.html">
     * http://www.24h.com.vn/tai-nan-giao-thong-c408.html</a>
     */
    public HashSet<String> website24h() {
        return website24h(WEBSITE_24H_COM_VN);
    }

    /**
     * 
     * @param url nguồn url để lấy các links từ trang 24h.com.vn
     * @return Các links về mục tai nạn giao thông tại trang <code>url</code>
     */
    public HashSet<String> website24h(String url) {
        connectUrl(url);

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
     * Lấy links từ "http://tintuc.vn/giao-thong?page=<b>pageBegin</b>"</ br>
     * tới "http://tintuc.vn/giao-thong?page=<b>pageEnd</b> về chuyên mục
     * giao thông
     *
     * @param pageBegin
     * @param pageEnd
     * @return Các links về mục tai nạn giao thông tại trang
     * <a href="http://tintuc.vn/giao-thong">
     * http://tintuc.vn/giao-thong</a>
     */
    public HashSet<String> tinTucVn(int pageBegin, int pageEnd) {

        HashSet<String> links = new HashSet<>();

        for (int i = pageBegin; i <= pageEnd; i++) {
            connectUrl("http://tintuc.vn/giao-thong?page=" + i);

            elements = document.select("a[href]");
            iterator = elements.iterator();

            while (iterator.hasNext()) {
                String s = iterator.next().attr("href");
                if (s.contains("/giao-thong/")) {
                    links.add(s);
                }
            }
        }

        return links;
    }

    /**
     * Lấy links từ "http://news.zing.vn/giao-thong/trang<b>pageBegin</b>.html"
     * </ br>
     * tới "http://news.zing.vn/giao-thong/trang<b>pageEnd</b>.html" về chuyên mục
     * giao thông
     *
     * @param pageBegin nên bằng 1 để lấy tin mới nhất
     * @param pageEnd nên có giá trị tối đa là 30
     * @return Các links về mục tai nạn giao thông tại trang
     * <a href ="http://news.zing.vn/giao-thong.html">
     * http://news.zing.vn/giao-thong.html</a>
     */
    public HashSet<String> zingVn(int pageBegin, int pageEnd) {

        HashSet<String> links = new HashSet<>();

        for (int i = pageBegin; i <= pageEnd; i++) {
            connectUrl("http://news.zing.vn/giao-thong/trang" + i + ".html");

            elements = document.getElementsByClass("cate_content");

            Document tmp = Jsoup.parse(elements.toString());

            elements = tmp.select("a[href]");

            iterator = elements.iterator();

            while (iterator.hasNext()) {
                String s = iterator.next().attr("href");
                if (!s.contains("/giao-thong/trang") && !s.contains("javascript")) {
                    links.add("http://news.zing.vn" + s);
                }
            }
        }
        return links;
    }
}
