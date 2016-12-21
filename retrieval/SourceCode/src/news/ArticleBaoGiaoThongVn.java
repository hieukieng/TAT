package news;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author TrungBK
 */
public class ArticleBaoGiaoThongVn extends Article {

    public ArticleBaoGiaoThongVn() {
    }

    @Override
    protected StringBuilder parseContent() {
        StringBuilder content = new StringBuilder();

        Elements pcelements = document.getElementsByTag("p");

        Element scelement = document.getElementsByClass("signature").first();

        int i = 0;
        for (Element pcelement : pcelements) {
            i++;
            if ((i == 1) || pcelement.text().contains("Xem thêm video")) {
                continue;
            }
            if (pcelement == scelement) {
                break;
            } else {
                content.append(pcelement.text());
            }
        }

        return content;
    }

    @Override
    public Timestamp convertDateTime(Document document) {
        Elements elements = document.select("div[class=font11 blue margin8_tb]");

        String s = elements.text().replace(" -", "");

        String datetime = s.substring(s.indexOf("/") - 2, s.indexOf("/") + 14);

        Date parseDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss:SSS");
            parseDate = dateFormat.parse(datetime + ":00:0");

        } catch (Exception e) {
            System.out.println("Khong the chuyen doi");
        }
        return new Timestamp(parseDate.getTime());
    }

    @Override
    protected String getFirstImageUrl(Document document) {
        String linkimg;
        Element element = document.select("table img[src]").first();
        linkimg = element.attr("src");
        return linkimg;
    }
}