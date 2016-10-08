package news;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author HAVIETTRANG
 */
public class NewsHeader {

    private String title;
    private Timestamp date;
    private String description;
    private String url;
    private static Document doc;

    public NewsHeader() {
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    /**
     * Phan tich cu phap cua trang co dia chi URL roi set Title, Date, Description va URL
     * @param url 
     */
    public void parseUrl(URL url) {
        try {
            doc = Jsoup.connect(url.toString()).timeout(10000).userAgent("Chrome").get();

            this.title = doc.title();

            this.description = doc.select("meta[name=description]").attr("content");

            this.url = doc.baseUri();
//            this.url = url.toString();

            Elements element = doc.getElementsByClass("baiviet-ngay");
            this.date = convertDate(element.text());

        } catch (IOException ex) {
            System.out.println("Connect error!");
            ex.printStackTrace();
            Logger.getLogger(NewsHeader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Chuyen doi thoi gian dang bai tren trang 24h.com.vn
     * @param string
     * @return Thoi gian dang bai voi kieu du lieu Timestamp
     * VD: Thứ Năm, ngày 15/09/2016 09:42 AM (GMT+7)
     * return: 15/09/2016 09:42:00.0
     */
    private Timestamp convertDate(String string) {
        String datetime = string.substring(string.indexOf("/") - 2, string.indexOf("/") + 14);
        Date parseDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
            parseDate = dateFormat.parse(datetime + ":00:0");

        } catch (Exception e) {
            System.out.println("Khong the chuyen doi");
            e.printStackTrace();
        }
        return new Timestamp(parseDate.getTime());
    }
}
