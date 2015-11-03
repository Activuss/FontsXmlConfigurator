package client;

import domain.Family;
import domain.Font;
import domain.Fonts;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarshallerClient {
    public static void main(String[] args) {

        Fonts fonts = new Fonts();

        Family family = new Family();
        family.setName("Arial");

        List<Font> fontList = new ArrayList<Font>();

        Font font = new Font();
        font.setStyle("normal italic");
        font.setWeight("normal bold");
        font.setFileName("arial-ttf");

        Font font2 = new Font();
        font2.setStyle("normal italic");
        font2.setWeight("normal bold");
        font2.setFileName("arial-ttf");


//        fontList.add(font);
        fontList.add(font2);

        family.setFonts(fontList);
        fonts.setFamily(Arrays.asList(family));

        try {
            File file = new File("classpath:file.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Fonts.class);
//            JAXBContext jaxbContext = JAXBContext.newInstance(Font.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

//            marshaller.marshal(font, file);
            marshaller.marshal(fonts, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
