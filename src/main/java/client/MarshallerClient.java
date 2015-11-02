package client;

import domain.Font;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class MarshallerClient {
    public static void main(String[] args) {
        Font font = new Font();
        font.setFamily("Arial");
        font.setStyle("normal italic");
        font.setWeight("normal bold");
        font.setFileName("arial-ttf");

        try {
            File file = new File("classpath:file.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Font.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(font, file);
            marshaller.marshal(font, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
