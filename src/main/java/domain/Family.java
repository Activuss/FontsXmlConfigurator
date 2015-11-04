package domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "family")
public class Family {
    private List<Font> fontList;
    private String name;

    public List<Font> getFonts() {
        return fontList;
    }

    @XmlElement(name = "font")
    public void setFonts(List<Font> fonts) {
        this.fontList = fonts;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Family{" +
                "fontList=" + fontList +
                ", name='" + name + '\'' +
                '}';
    }
}
