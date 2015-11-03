package client;

import com.google.common.io.Resources;
import domain.Family;
import domain.Font;
import domain.Fonts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class UnmarshallerClient {
    public static void main(String[] args) {
        try {
            URL url = Resources.getResource("file.xml");

            File file = new File(url.toURI());
            JAXBContext jaxbContext = JAXBContext.newInstance(Fonts.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Fonts fonts = (Fonts) unmarshaller.unmarshal(file);

            List<Family> fontFamilies = fonts.getFamily();

            for (Family family : fontFamilies) {
                for (Font font : family.getFonts()) {
                    System.out.println(font.getStyle());
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}

