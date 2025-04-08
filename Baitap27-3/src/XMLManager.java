import javax.xml.bind.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLManager {
    private List<XMLElement> elements = new ArrayList<>();
    private final String FILE_PATH = "data.xml";

    public void createElement(String name, String value) {
        elements.add(new XMLElement(name, value));
        saveToFile();
    }

    public List<XMLElement> readElements() {
        return elements;
    }

    public void updateElement(int index, String name, String value) {
        if (index >= 0 && index < elements.size()) {
            elements.get(index).setName(name);
            elements.get(index).setValue(value);
            saveToFile();
        }
    }

    public void deleteElement(int index) {
        if (index >= 0 && index < elements.size()) {
            elements.remove(index);
            saveToFile();
        }
    }

    public void saveToFile() {
        try {
            JAXBContext context = JAXBContext.newInstance(XMLElementListWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            XMLElementListWrapper wrapper = new XMLElementListWrapper(elements);
            marshaller.marshal(wrapper, new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return;

            JAXBContext context = JAXBContext.newInstance(XMLElementListWrapper.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            XMLElementListWrapper wrapper = (XMLElementListWrapper) unmarshaller.unmarshal(file);
            elements = wrapper.getElements();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}