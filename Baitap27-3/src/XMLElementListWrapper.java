import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "elements")
class XMLElementListWrapper {
    private List<XMLElement> elements;

    public XMLElementListWrapper() {}

    public XMLElementListWrapper(List<XMLElement> elements) {
        this.elements = elements;
    }

    @XmlElement(name = "element")
    public List<XMLElement> getElements() {
        return elements;
    }

    public void setElements(List<XMLElement> elements) {
        this.elements = elements;
    }
}