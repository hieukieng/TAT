package rssfeeds;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

/**
 * @author Phạm Tuấn
 * @date Oct 20, 2016 10:35:25 AM
 */
public class RSSReader {

    private static final String ITEM = "item";
    private static final String LINK = "link";

    /**
     * lấy toàn bộ link bài viết từ RSS
     *
     * @param rssLink URL (địa chỉ) của RSS feed
     * @return các link được lưu trong {@code ArratList<String>}
     * @throws Exception nếu quá trình phân tích link gặp lỗi
     * @see java.util.ArrayList
     */
    public static ArrayList<String> getAllLink(String rssLink) throws Exception {
        ArrayList<String> links = new ArrayList<>();

        URL url = new URL(rssLink);

        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        InputStream in = url.openStream();
        XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

        String link = "";

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();
            if (event.isStartElement()) {
                String localPart = event.asStartElement().getName().getLocalPart();
                if (localPart.equals(ITEM)) {
                    eventReader.nextEvent();
                }

                if (localPart.equals(LINK)) {
                    link = getCharacterData(event, eventReader);
                }
            } else if (event.isEndElement()) {
                if (event.asEndElement().getName().getLocalPart().equals(ITEM)) {
                    links.add(link);
                    eventReader.nextEvent();
                }
            }

        }

        return links;
    }

    private static String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }
}
