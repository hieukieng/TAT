package news;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Feb 26, 2017 12:08:37 PM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
/**
 * 
 * @author HAVIETTRANG
 */
public class ArticleNldComVn extends Article{

    private Elements elements;
    public ArticleNldComVn() {
    }
    
    @Override
    protected StringBuilder parseContent() {
        StringBuilder content = new StringBuilder();
        
        elements = document.select("div[class=\"contentdetail\"] p");
        
        for (Iterator<Element> i = elements.iterator(); i.hasNext();) {
            Element next = i.next();
            content.append(next.text());
        }
        return content;
    }

    @Override
    protected Timestamp convertDateTime(Document document) {
        //<p class="ngayxuatban">25/02/2017 15:27</p>
        elements = document.select("p[class=\"ngayxuatban\"]");
        
        StringBuilder datetime = new StringBuilder(elements.text());
        
        Date parseDate = null;
        
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
            
            parseDate = dateFormat.parse(datetime.append(":00:0").toString());
        } catch (ParseException e) {
            System.out.println("Can't convert date time");
            e.printStackTrace();
        }
        return new Timestamp(parseDate.getTime());
    }

    @Override
    protected String getFirstImageUrl(Document document) {
        elements = document.select("div[class=\"VCSortableInPreviewMode\"");
        
        return elements.select("img[src~=(?i)\\.(png|jpe?g|gif)]").attr("src");
    }

}
