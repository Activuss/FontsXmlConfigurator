package domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Font {
    private String family;
    private String style;
    private String weight;
    private String fileName;

    public String getFamily() {
        return family;
    }

    @XmlElement
    public void setFamily(String family) {
        this.family = family;
    }

    public String getStyle() {
        return style;
    }

    @XmlAttribute
    public void setStyle(String style) {
        this.style = style;
    }

    public String getWeight() {
        return weight;
    }

    @XmlAttribute
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getFileName() {
        return fileName;
    }

    @XmlAttribute
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
