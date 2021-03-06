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
 * @date Nov 10, 2016 9:58:01 AM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class ArticleTinTucVn extends Article{

    private Elements elements;

    public ArticleTinTucVn() {
    }

    @Override
    protected StringBuilder parseContent() {
        StringBuilder content = new StringBuilder();
        
        elements = document.select("div[class=\"article-body col  w504 pull-right\"] p");
        for (Iterator<Element> i = elements.iterator(); i.hasNext();) {
            Element next = i.next();
            content.append(next.text());
        }
        return content;
    }

    @Override
    public Timestamp convertDateTime(Document document) {
        //<span class="publish-date">21:00 ngày 15/10/2016</span>
        elements = document.getElementsByClass("publish-date");
        
        String string = elements.text();
        
        StringBuilder datetime = new StringBuilder(string.substring(12, 21));
        
        datetime.append(" ").append(string.substring(0, 5));
        
        Date parseDate = null;
        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
            
            parseDate = dateFormat.parse(datetime.append(":00:0").toString());
            
        } catch (Exception e) {
            System.out.println("Can't convert date time");
            e.printStackTrace();
        }
        return new Timestamp(parseDate.getTime());
    }

    @Override
    protected String getFirstImageUrl(Document document) {
        elements = document.getElementsByClass("post-body");
        
        return elements.select("img[src~=(?i)\\.(png|jpe?g|gif)]").attr("src");
    }


}
