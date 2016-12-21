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
        return content.toString().trim();
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    /**
     * Phân tích cấu trúc của trang web cung cấp từ biến truyền vào
     * {@code url}. Các thông tin của bài viết cần lấy bao gồm:
     * <ul><li>{@code title}: title của bài viết
     * <li>{@code date}: thời gian đăng bài viết, kiểu {@link java.sql.Timestamp}
     * <li>{@code description}: mô tả tóm tắt nội dung bài viết
     * <li>{@code URL}: địa chỉ bài viết
     * <li>{@code imageUrl}: url ảnh đầu tiên của bài viết
     * <li>{@code content}: nội dung bài viết
     * </ul>
     * @param url 
     */
    public void parseUrl(String url) {
        connectUrl(url);

        title = document.title().trim();

        date = convertDateTime(document);

        description = document.select("meta[name=description]").attr("content").trim();

        this.url = url;

        imageUrl = getFirstImageUrl(document);
        
        content = parseContent();
    }
    
    /**
     * Lấy dữ liệu của trang web lưu dưới dạng {@link org.jsoup.nodes.Document}
     * từ địa chỉ {@code url} cụ thể sử dụng Jsoup với <b>time out</b> = 10s
     * sử dụng agent <i>Chrome</i> 
     * @param url của trang web cần lấy thông tin
     */
    protected void connectUrl(String url) {
        try {
            document = Jsoup.connect(url).timeout(10000).userAgent("Chrome").get();
        } catch (IOException ex) {
            System.out.println("Can't connect to website " + url);
            ex.printStackTrace();
        }
    }

    /**
     * Phân tách lấy nội dung của bài viết dưới dạng text,
     *  mỗi trang sẽ có cấu trúc thiết kế khác nhau do đó cần viết
     * hàm này độc lập cho mỗi trang
     * @return nội dung bài viết dưới dạng text
     */
    protected abstract StringBuilder parseContent();
    
    /**
     * Chuyển đổi ngày đăng bài viết từ kiểu <i>text</i> sang
     * kiểu {@link java.sql.Timestamp} để lưu vào cơ sở dữ liệu
     * @param document dữ liệu bài viết
     * @return thời gian đăng bài
     */
    protected abstract Timestamp convertDateTime(Document document);
    
    /**
     * Lấy URL ảnh đầu tiên trong bài viết, nếu không thành công thì trả về
     * link ảnh mặc định <i>https://s-media-cache-ak0.pinimg.com/564x/69/2b/7f/692b7fdec925793d38b4dd90ffb6e384.jpg</i>
     * @param document
     * @return 
     */
    protected abstract String getFirstImageUrl(Document document);
}
