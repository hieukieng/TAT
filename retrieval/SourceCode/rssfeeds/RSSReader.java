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
 * @author HAVIETTRANG
 * @date Oct 20, 2016 10:35:25 AM
 * @website haviettrang.blogspot.com
 */
public class RSSReader {

    private static final String ITEM = "item";
    private static final String LINK = "link";

    public static ArrayList<URL> getAllLink(String rssLink) throws Exception {
        ArrayList<URL> links = new ArrayList<>();

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
                    links.add(new URL(link));
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
