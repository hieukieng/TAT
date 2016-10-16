/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package news;

import database.TrafficAccident;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author HAVIETTRANG
 */
public class NewsContent {

    private StringBuilder content;
    private Document doc;

    public NewsContent() {
    }

    public String getContent() {
        return content.toString();
    }

    /**
     * Phan tich cu phap cua trang co dia chi URL roi set Content
     * @param url 
     */
    public void parseUrl(URL url) {
        try {
            doc = Jsoup.connect(url.toString()).timeout(10000).userAgent("Chrome").get();

            Elements element = doc.getElementsByClass("baiviet-sapo");
            this.content.append(element.text());
            
            element = doc.getElementsByClass("text-conent");
            String conent = element.text();
            
            Element lienQuan = doc.getElementsByAttributeValue("class", "baiviet-bailienquan").first();
            
            this.content.append(conent.replace(lienQuan.text(), ""));
        } catch (IOException ex) {
            System.out.println("Connect error!");
            ex.printStackTrace();
            Logger.getLogger(NewsHeader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
