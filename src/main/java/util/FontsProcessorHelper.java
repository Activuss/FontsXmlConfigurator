package util;


import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.io.Resources;
import domain.Document;
import domain.Font;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FontsProcessorHelper {

    public static final Logger LOG = Logger.getLogger("FontsProcessorHelper.class");

    public static Optional<Document> unmarshall() {
        URL url = Resources.getResource("file.xml");
        Optional<Document> optionalDocument = Optional.absent();
        try {
            File file = new File(url.toURI());
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);

            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            optionalDocument = Optional.fromNullable((Document) unmarshaller.unmarshal(file));
            return optionalDocument;
        } catch (JAXBException e) {
            LOG.log(Level.WARNING, "Error while unmarshalling the given xml file: " + e.getMessage());
            return optionalDocument;
        } catch (URISyntaxException e) {
            LOG.log(Level.WARNING, "Error while reaching given xml file: " + e.getMessage());
            return optionalDocument;
        }
    }

    public static Optional<List<Font>> getFonts(Optional<Document> documentContent) {
        Preconditions.checkArgument(documentContent.isPresent(),
                "Unable to proceed due to absence of needed document content");
        List<Font> fontsFromDocument = FluentIterable
                .from(documentContent.get().getFamily())
                .transformAndConcat(new ExtractFontsFunction())
                .toList();

        return Optional.fromNullable(fontsFromDocument);
    }

    public static Optional<List<Font>> getNormalFonts(Optional<List<Font>> fonts) {
        Preconditions.checkArgument(fonts.isPresent(), "Unable to proceed due to absence of fonts");
        Predicate<Font> isNormal = new Predicate<Font>() {
            public boolean apply(Font input) {
                return input.getStyle().contains("normal");
            }
        };

        List<Font> normalFonts = FluentIterable
                .from(fonts.get())
                .filter(isNormal)
                .toList();

        return Optional.fromNullable(normalFonts);
    }

    public static Optional<Set<String>> getFileNames(Optional<List<Font>> fonts) {
        Preconditions.checkArgument(fonts.isPresent(), "Unable to proceed due to absence of fonts");
        Set<String> filenames = FluentIterable
                .from(fonts.get())
                .transform(new ExtractFilenamesFunction())
                .toSet();

        return Optional.fromNullable(filenames);
    }


}
