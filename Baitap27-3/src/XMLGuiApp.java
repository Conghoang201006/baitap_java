import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XMLGuiApp {
    private XMLManager xmlManager;
    private DefaultListModel<String> listModel;
    private JList<String> xmlList;

    public XMLGuiApp() {
        xmlManager = new XMLManager();
        xmlManager.loadFromFile();

        JFrame frame = new JFrame("XML CRUD App");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        xmlList = new JList<>(listModel);
        updateList();

        JPanel panel = new JPanel(new GridLayout(2, 1));
        JTextField nameField = new JTextField();
        JTextField valueField = new JTextField();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Value:"));
        panel.add(valueField);

        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        frame.add(new JScrollPane(xmlList), BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String value = valueField.getText();
            if (!name.isEmpty() && !value.isEmpty()) {
                xmlManager.createElement(name, value);
                updateList();
            }
        });

        updateButton.addActionListener(e -> {
            int index = xmlList.getSelectedIndex();
            if (index != -1) {
                String name = nameField.getText();
                String value = valueField.getText();
                xmlManager.updateElement(index, name, value);
                updateList();
            }
        });

        deleteButton.addActionListener(e -> {
            int index = xmlList.getSelectedIndex();
            if (index != -1) {
                xmlManager.deleteElement(index);
                updateList();
            }
        });

        frame.setVisible(true);
    }

    private void updateList() {
        listModel.clear();
        for (XMLElement elem : xmlManager.readElements()) {
            listModel.addElement(elem.getName() + ": " + elem.getValue());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(XMLGuiApp::new);
    }
}