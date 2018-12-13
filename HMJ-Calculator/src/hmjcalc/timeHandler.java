/*
 * Will print into the HMJGUI when called
 */
package hmjcalc;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Alex
 */
public class timeHandler {

    private static List<String> zoneNames = new ArrayList<>();
    private static List<String> timeStamps = new ArrayList<>();

    public static List<String> getZoneNames() {
        return zoneNames;
    }

    public static List<String> getTimeStamps() {
        return timeStamps;
    }


    public static void main() {
        //1544749680 is just an EXAMPLE for now
        /*java.util.Date time = new java.util.Date((long) 1544749680 * 1000);
        String hour = time.toString().substring(11, 13);
        if (hour.equals("17")) {
            System.out.println(hour);
        } else {
            System.out.println("Don't drink yet!");
        }*/

        //REF: https://www.youtube.com/watch?v=HfGWVy-eMRc
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("timezonedb.xml");
            //zoneName will be the unique identifier
            NodeList zList = doc.getElementsByTagName("zoneName");
            NodeList tList = doc.getElementsByTagName("timestamp");
            for (int i = 0; i < zList.getLength(); i++) {
                Node z = zList.item(i);
                Node t = tList.item(i);
                //only need to loop through one item
                if (z.getNodeType() == Node.ELEMENT_NODE) {
                    Element zt = (Element) z;
                    Element tt = (Element) t;
                    zoneNames.add(zt.getTextContent());
                    timeStamps.add(tt.getTextContent());
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(timeHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(timeHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(timeHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(Arrays.toString(zoneNames.toArray())); //test
        //System.out.println(Arrays.toString(timeStamps.toArray())); //test

    }

}
