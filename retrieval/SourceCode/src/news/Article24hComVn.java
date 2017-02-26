package news;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 10, 2016 9:14:38 AM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class Article24hComVn extends Article{

    private Elements elements;
    
    public Article24hComVn() {
    }

    @Override
    protected StringBuilder parseContent() {
        
        elements = document.getElementsByClass("baiviet-sapo");
        
        StringBuilder content = new StringBuilder(elements.text());
        
        elements = document.getElementsByClass("text-conent");
        elements = elements.first().children();
        
        Iterator<Element> i = elements.iterator();
        
        while(i.hasNext()) {
            Element e = i.next();
            if (!e.hasClass("baiviet-bailienquan") && !e.hasAttr("style")) {
                content.append(e.text());
            }
        }

        return content;
    }

    
    //if 15/09/2016 09:42 AM (GMT+7) then return: 15/09/2016 09:42:00.0
    @Override
    public Timestamp convertDateTime(Document document) {
        elements = document.getElementsByClass("baiviet-ngay");
        
        String s = elements.text();
        
        StringBuilder datetime = new StringBuilder(s.substring(s.indexOf("/") - 2, s.indexOf("/") + 14));
        Date parseDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
            parseDate = dateFormat.parse(datetime.append(":00:0").toString());

        } catch (Exception e) {
            System.out.println("Can't convert time");
            e.printStackTrace();
        }
        return new Timestamp(parseDate.getTime());
    }

    @Override
    protected String getFirstImageUrl(Document document) {
        elements = document.getElementsByClass("text-conent");
        
        return elements.select("img[src~=(?i)\\.(png|jpe?g|gif)]").attr("src");
    }

}
