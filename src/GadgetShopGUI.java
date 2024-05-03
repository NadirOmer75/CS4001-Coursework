import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// Main class for the Gadget Shop GUI
public class GadgetShopGUI extends JFrame implements ActionListener {
    // List to store all gadgets added to the shop
    private ArrayList<Gadget> gadgets = new ArrayList<>();
    // Text fields for user input on various gadget attributes
    private JTextField modelTextField, priceTextField, weightTextField, sizeTextField, creditTextField, memoryTextField, phoneNumberTextField, durationTextField, downloadSizeTextField, displayNumberTextField;
    // Buttons for different functionalities
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadMusicButton;

    // Constructor that initializes the GUI
    public GadgetShopGUI() {
        createGUI();
        // Show welcome message upon application start
        JOptionPane.showMessageDialog(this, "Welcome to Gadget Shop", "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to set up the GUI layout and components
    private void createGUI() {
        setTitle("Gadget Shop"); // Set window title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation
        setLayout(new GridBagLayout()); // Use GridBagLayout for flexible layout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 2, 2, 2);

        // Array of labels for user inputs
        String[] labels = {"Model:", "Price:", "Weight:", "Size:", "Credit:", "Memory:", "Phone Number:", "Duration:", "Download Size:", "Display Number:"};
        JTextField[] fields = {modelTextField = new JTextField(20), priceTextField = new JTextField(20), weightTextField = new JTextField(20),
                               sizeTextField = new JTextField(20), creditTextField = new JTextField(20), memoryTextField = new JTextField(20),
                               phoneNumberTextField = new JTextField(20), durationTextField = new JTextField(20), downloadSizeTextField = new JTextField(20),
                               displayNumberTextField = new JTextField(20)};
        // Loop to add labels and text fields dynamically
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1;
            add(fields[i], gbc);
            gbc.gridy++;
        }

        // Button labels
        String[] buttonLabels = {"Add Mobile", "Add MP3", "Clear", "Display All", "Make a Call", "Download Music"};
        JButton[] buttons = {addMobileButton = new JButton(buttonLabels[0]), addMP3Button = new JButton(buttonLabels[1]), clearButton = new JButton(buttonLabels[2]),
                             displayAllButton = new JButton(buttonLabels[3]), makeCallButton = new JButton(buttonLabels[4]), downloadMusicButton = new JButton(buttonLabels[5])};
        // Loop to add buttons dynamically
        for (JButton button : buttons) {
            button.addActionListener(this);
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            add(button, gbc);
            gbc.gridy++;
        }

        pack(); // Pack the frame to adjust to contents
        setLocationRelativeTo(null); // Center the window
        setVisible(true); // Make the frame visible
    }

    // Method called when an action is performed
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Determine which button was pressed and act accordingly
            if (e.getSource() == addMobileButton) {
                Mobile mobile = new Mobile(
                    modelTextField.getText(),
                    Double.parseDouble(priceTextField.getText()),
                    Integer.parseInt(weightTextField.getText()),
                    sizeTextField.getText(),
                    Integer.parseInt(creditTextField.getText())
                );
                gadgets.add(mobile);
                JOptionPane.showMessageDialog(this, "Mobile added!");
            } else if (e.getSource() == addMP3Button) {
                MP3 mp3 = new MP3(
                    modelTextField.getText(),
                    Double.parseDouble(priceTextField.getText()),
                    Integer.parseInt(weightTextField.getText()),
                    sizeTextField.getText(),
                    Integer.parseInt(memoryTextField.getText())
                );
                gadgets.add(mp3);
                JOptionPane.showMessageDialog(this, "MP3 added!");
            } else if (e.getSource() == clearButton) {
                clearFields();
            } else if (e.getSource() == displayAllButton) {
                displayAllGadgets();
                JOptionPane.showMessageDialog(this, "Displayed all gadgets.", "Display All", JOptionPane.INFORMATION_MESSAGE);
            } else if (e.getSource() == makeCallButton) {
                makeCall();
            } else if (e.getSource() == downloadMusicButton) {
                downloadMusic();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Invalid display number.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear all text fields
    private void clearFields() {
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        creditTextField.setText("");
        memoryTextField.setText("");
        phoneNumberTextField.setText("");
        durationTextField.setText("");
        downloadSizeTextField.setText("");
        displayNumberTextField.setText("");
    }

    // Method to display all gadgets
    private void displayAllGadgets() {
        StringBuilder allGadgets = new StringBuilder("All Gadgets:\n");
        for (int i = 0; i < gadgets.size(); i++) {
            allGadgets.append(i + 1).append(". ").append(gadgets.get(i).toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, allGadgets.toString(), "Gadgets List", JOptionPane.INFORMATION_MESSAGE);
    }

    // Method to handle making a call
    private void makeCall() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1 && gadgets.get(displayNumber) instanceof Mobile) {
            Mobile mobile = (Mobile) gadgets.get(displayNumber);
            mobile.makeCall(phoneNumberTextField.getText(), Integer.parseInt(durationTextField.getText()));
            JOptionPane.showMessageDialog(this, "Call made successfully!", "Call Status", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selected gadget is not a mobile or invalid display number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to handle downloading music
    private void downloadMusic() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1 && gadgets.get(displayNumber) instanceof MP3) {
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            mp3.downloadMusic(Integer.parseInt(downloadSizeTextField.getText()));
            JOptionPane.showMessageDialog(this, "Music downloaded successfully!", "Download Status", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selected gadget is not an MP3 or invalid display number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to retrieve the display number and validate it
    private int getDisplayNumber() {
        try {
            int index = Integer.parseInt(displayNumberTextField.getText()) - 1;
            if (index >= 0 && index < gadgets.size()) {
                return index;
            } else {
                JOptionPane.showMessageDialog(this, "Display number out of range.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return -1;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid display number format.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new GadgetShopGUI();
    }
}
