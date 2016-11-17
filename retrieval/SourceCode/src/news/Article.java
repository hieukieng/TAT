package news;

import java.io.IOException;
import java.sql.Timestamp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Hà Viết Tráng - HAVIETTRANG
 * @date Nov 10, 2016 9:01:52 AM
 * @website haviettrang.blogspot.com
 * @Notes View my notes at haviettrang.postach.io
 */
public abstract class Article {

    protected Document document;
    private String title;
    private Timestamp date;
    private String description;
    private String url;
    private String imageUrl;
    private StringBuilder content;

    public Article() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content.toString();
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    public void parseUrl(String url) {
        connectUrl(url);

        setTitle(document.title());

        setDate(convertDateTime(document));

        setDescription(document.select("meta[name=description]").attr("content"));

        setUrl(url);

        setImageUrl(getFirstImageUrl(document));
        
        setContent(parseContent());
    }

    protected void connectUrl(String url) {
        try {
            document = Jsoup.connect(url).timeout(10000).userAgent("Chrome").get();
        } catch (IOException ex) {
            System.out.println("Can't connect to website " + url);
            ex.printStackTrace();
        }
    }

    protected abstract StringBuilder parseContent();
    
    protected abstract Timestamp convertDateTime(Document document);
    
    protected abstract String getFirstImageUrl(Document document);
}
