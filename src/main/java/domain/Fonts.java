package domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by illya.kolykhanin on 11/3/2015.
 */
@XmlRootElement
public class Fonts {
    @XmlElement
    private List<Family> familyList;

    public List<Family> getFamily() {
        return familyList;
    }

    public void setFamily(List<Family> family) {
        this.familyList = family;
    }

    @Override
    public String toString() {
        return "Fonts{" +
                "familyList=" + familyList +
                '}';
    }
}
