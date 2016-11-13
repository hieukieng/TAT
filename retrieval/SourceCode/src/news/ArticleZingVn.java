package news;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 13, 2016 12:11:44 AM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public class ArticleZingVn extends Article {

    private Elements elements;

    public ArticleZingVn() {
    }

    @Override
    public void parseContent(String url) {
        connectUrl(url);
        elements = document.getElementsByClass("the-article-summary");

        StringBuilder content = new StringBuilder(elements.text());
        elements = document.getElementsByClass("the-article-body");
        String conent = elements.text();

        //loai bo phan thua
        Elements lienQuan = document.getElementsByClass("inner-article");

        content.append(conent.replace(lienQuan.text(), ""));
        setContent(content);
        elements = document.getElementsByClass("the-article-publish");
        String s = elements.text();
        System.out.println(s.substring(0, 5) + ":00.0");
    }

    @Override
    public Timestamp convertDateTime(Document document) {
        elements = document.getElementsByClass("the-article-publish");
        String s = elements.text();
        StringBuilder datetime = new StringBuilder(s.substring(6));
        datetime = (datetime.append(s.substring(0, 0))).append(":00.0");
        Date parseDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
        try {
            parseDate = dateFormat.parse(datetime.toString());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return new Timestamp(parseDate.getTime());
    }

    @Override
    protected String getFirstImageUrl(Document document) {
        elements = document.getElementsByClass("the-article-body cms-body");

        return elements.select("img[src~=(?i)\\.(png|jpe?g|gif)]").attr("src");
    }

}
