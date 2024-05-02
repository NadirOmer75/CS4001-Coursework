import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * GadgetShop manages a list of gadgets and provides a GUI for interacting with those gadgets.
 * It allows adding, displaying, and interacting with different types of gadgets like mobiles and MP3 players.
 */
public class GadgetShop implements ActionListener {

    // GUI components
    private JFrame frame;
    private JTextField modelTextField, priceTextField, weightTextField, sizeTextField,
        creditTextField, memoryTextField, phoneNumberTextField, durationTextField, downloadTextField, displayNumberTextField;
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadButton;

    // List to store all the gadgets added to the shop
    private ArrayList<Gadget> gadgets = new ArrayList<>();

    /**
     * Constructor for GadgetShop.
     * Initializes the GUI by calling makeFrame method.
     */
    public GadgetShop() {
        makeFrame();
    }

    /**
     * Creates the main GUI frame and initializes all components.
     */
    private void makeFrame() {
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(7, 4));

        // Adding text fields and their corresponding labels to the frame
        modelTextField = addFieldWithLabel(contentPane, "Model:");
        priceTextField = addFieldWithLabel(contentPane, "Price:");
        weightTextField = addFieldWithLabel(contentPane, "Weight:");
        sizeTextField = addFieldWithLabel(contentPane, "Size:");
        creditTextField = addFieldWithLabel(contentPane, "Credit:");
        memoryTextField = addFieldWithLabel(contentPane, "Memory:");
        phoneNumberTextField = addFieldWithLabel(contentPane, "Phone Number:");
        durationTextField = addFieldWithLabel(contentPane, "Duration:");
        downloadTextField = addFieldWithLabel(contentPane, "Download:");
        displayNumberTextField = addFieldWithLabel(contentPane, "Display Number:");

        // Adding buttons and setting action listeners for each
        addMobileButton = addButtonWithListener(contentPane, "Add Mobile");
        addMP3Button = addButtonWithListener(contentPane, "Add MP3");
        clearButton = addButtonWithListener(contentPane, "Clear");
        displayAllButton = addButtonWithListener(contentPane, "Display All");
        makeCallButton = addButtonWithListener(contentPane, "Make a Call");
        downloadButton = addButtonWithListener(contentPane, "Download Music");

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Handles action events triggered by GUI components.
     * Delegates actions based on the command associated with the event source.
     */
    public void actionPerformed(ActionEvent event) {
        try {
            String command = event.getActionCommand();
            switch (command) {
                case "Add Mobile":
                    addMobile();
                    break;
                case "Add MP3":
                    addMP3();
                    break;
                case "Clear":
                    clear();
                    break;
                case "Display All":
                    displayAll();
                    break;
                case "Make a Call":
                    makeCall();
                    break;
                case "Download Music":
                    downloadMusic();
                    break;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Private helper methods for GUI initialization and action handling

    private JTextField addFieldWithLabel(Container contentPane, String label) {
        JLabel jLabel = new JLabel(label);
        contentPane.add(jLabel);
        JTextField textField = new JTextField(15);
        contentPane.add(textField);
        return textField;
    }

    private JButton addButtonWithListener(Container contentPane, String buttonText) {
        JButton button = new JButton(buttonText);
        contentPane.add(button);
        button.addActionListener(this);
        return button;
    }

    private void addMobile() {
        // Method implementation for adding a mobile gadget
    }

    private void addMP3() {
        // Method implementation for adding an MP3 gadget
    }

    private void clear() {
        // Clears all text fields
    }

    private void displayAll() {
        // Displays information about all gadgets
    }

    private void makeCall() {
        // Handles making a call using a mobile gadget
    }

    private void downloadMusic() {
        // Handles downloading music to an MP3 gadget
    }

    // Helper methods to retrieve data from text fields

    private String getModel() { return modelTextField.getText(); }
    private double getPrice() { return Double.parseDouble(priceTextField.getText()); }
    private int getWeight() { return Integer.parseInt(weightTextField.getText()); }
    private String getSize() { return sizeTextField.getText(); }
    private int getCredit() { return Integer.parseInt(creditTextField.getText()); }
    private int getMemory() { return Integer.parseInt(memoryTextField.getText()); }
    private String getPhoneNumber() { return phoneNumberTextField.getText(); }
    private int getDuration() { return Integer.parseInt(durationTextField.getText()); }
    private int getDownload() { return Integer.parseInt(downloadTextField.getText()); }
    private int getDisplayNumber() { return Integer.parseInt(displayNumberTextField.getText()) - 1; }
}
