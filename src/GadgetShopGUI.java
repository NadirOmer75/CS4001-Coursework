/**
 * Gadget Shop application for adding MP3 Players, Mobile/Smart Phones, making calls and downloading music.
 *
 * @author (Nadir Omer Ahmed Ismail)
 * @version (03/05/2024)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//The main class of the Gadget Shop GUI is in charge of constructing the components that make up the application window.
public class GadgetShopGUI extends JFrame implements ActionListener {
    // All of the devices that have been added to the shop are listed, enabling dynamic addition and management.
    private ArrayList<Gadget> gadgets = new ArrayList<>();
    private JTextField modelTextField, priceTextField, weightTextField, sizeTextField, // Data entry is made easier with text fields for user input on several gadget properties.
                        creditTextField, memoryTextField, phoneNumberTextField, 
                        durationTextField, downloadSizeTextField, displayNumberTextField;

    
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, // Text boxes that allow users to enter data on different gadget properties.
                    makeCallButton, downloadMusicButton;

    
    public GadgetShopGUI() { // The constructor sets up the GUI and shows a greeting when it is launched.
        createGUI(); // Invokes the function that builds the GUI's components and layout.
        // When the program launches, a welcome message appears in a dialog box.
        JOptionPane.showMessageDialog(this, "Welcome to Gadget Shop", "Welcome", JOptionPane.INFORMATION_MESSAGE);
    }

    
    private void createGUI() { // Uses GridBagLayout to set up the GUI components for a customizable configuration.
        setTitle("Gadget Shop"); // Enabled when the instance is executed.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Specifies how the window should behave when closed.
        setLayout(new GridBagLayout()); // Configures GridBagLayout managing the layout.

        GridBagConstraints gbc = new GridBagConstraints(); // GridBagConstraints to manage layout constraints.
        gbc.gridwidth = 1; // Sets the width for components to span one grid cell.
        gbc.gridx = 0; // Initial grid x position.
        gbc.gridy = 0; // Initial grid y position.
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allows components to grow horizontally.
        gbc.insets = new Insets(2, 2, 2, 2); // Sets padding around components.

        // Labels for the input fields, describing what data to enter.
        String[] labels = {"Model:", "Price:", "Weight:", "Size:", "Credit:", 
                           "Memory:", "Phone Number:", "Duration:", 
                           "Download Size:", "Display Number:"};

        // Array of text fields corresponding to each label.
        JTextField[] fields = {modelTextField = new JTextField(20), priceTextField = new JTextField(20),
                               weightTextField = new JTextField(20), sizeTextField = new JTextField(20),
                               creditTextField = new JTextField(20), memoryTextField = new JTextField(20),
                               phoneNumberTextField = new JTextField(20), durationTextField = new JTextField(20),
                               downloadSizeTextField = new JTextField(20), displayNumberTextField = new JTextField(20)};

        // Dynamically adding label and text field pairs to the GUI.
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; // Set label position.
            add(new JLabel(labels[i]), gbc); // Add label to the GUI.
            gbc.gridx = 1; // Set text field position next to the label.
            add(fields[i], gbc); // Add text field to the GUI.
            gbc.gridy++; // Increment the row position for the next pair.
        }

        // Labels for buttons that perform various functions.
        String[] buttonLabels = {"Add Mobile", "Add MP3", "Clear", "Display All", 
                                 "Make a Call", "Download Music"};
        
        // Buttons initialized with labels.
        JButton[] buttons = {addMobileButton = new JButton(buttonLabels[0]), addMP3Button = new JButton(buttonLabels[1]), 
                             clearButton = new JButton(buttonLabels[2]), displayAllButton = new JButton(buttonLabels[3]), 
                             makeCallButton = new JButton(buttonLabels[4]), downloadMusicButton = new JButton(buttonLabels[5])};

        // Adding buttons to the GUI.
        for (JButton button : buttons) {
            button.addActionListener(this); // To handle button clicks, an action listener is added.
            gbc.gridwidth = 2; // Makes the button two columns wide.
            gbc.gridx = 0; // The first column is where the button appears.
            add(button, gbc); // Expands the GUI with a button.
            gbc.gridy++; // Puts a button there and then advances to the next row.
        }

        pack(); // Automatically adjust window size to fit all components.
        setLocationRelativeTo(null); // Makes it so that the window is centred on the screen.
        setVisible(true); // Allows the window to be seen.
    }


    @Override
    public void actionPerformed(ActionEvent e) { // Method called when an action is performed
        try {
            // Identify the button that was pressed and take appropriate action.
            if (e.getSource() == addMobileButton) {
                Mobile mobile = new Mobile(
                    modelTextField.getText(),
                    Double.parseDouble(priceTextField.getText()),
                    Integer.parseInt(weightTextField.getText()),
                    sizeTextField.getText(),
                    Integer.parseInt(creditTextField.getText())
                );
                gadgets.add(mobile);
                JOptionPane.showMessageDialog(this, "Mobile added!"); // Prompts that a Mobile device has been added into the gadget list.
            } else if (e.getSource() == addMP3Button) {
                MP3 mp3 = new MP3(
                    modelTextField.getText(),
                    Double.parseDouble(priceTextField.getText()),
                    Integer.parseInt(weightTextField.getText()),
                    sizeTextField.getText(),
                    Integer.parseInt(memoryTextField.getText())
                );
                gadgets.add(mp3);
                JOptionPane.showMessageDialog(this, "MP3 added!"); // Prompts that a MP3 Device has been added into the gadget list.
            } else if (e.getSource() == clearButton) {
                clearFields();
            } else if (e.getSource() == displayAllButton) {
                displayAllGadgets();
                JOptionPane.showMessageDialog(this, "Displayed all gadgets.", "Display All", JOptionPane.INFORMATION_MESSAGE); // Message Dialog that Displays all the gadgets
            } else if (e.getSource() == makeCallButton) {
                makeCall();
            } else if (e.getSource() == downloadMusicButton) {
                downloadMusic();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE); // Prompts the user to enter valid numbers.
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, "Invalid display number.", "Input Error", JOptionPane.ERROR_MESSAGE); // Shows that the inputted value is an invalid display number.
        }
    }

   
    private void clearFields() {  // Deletes all of the GUI's input fields.
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

    
    private void displayAllGadgets() { // Shows every device that is presently kept in the list.
        StringBuilder allGadgets = new StringBuilder("All Gadgets:\n");
        for (int i = 0; i < gadgets.size(); i++) {
            allGadgets.append(i + 1).append(". ").append(gadgets.get(i).toString()).append("\n"); // Assuming toString() method is implemented in Gadget classes.
        }
        JOptionPane.showMessageDialog(this, allGadgets.toString(), "Gadgets List", JOptionPane.INFORMATION_MESSAGE);
    }

    
    private void makeCall() { // Method to initiate a phone call using a selected mobile gadget, if enough credit is available.
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1 && gadgets.get(displayNumber) instanceof Mobile) {
            Mobile mobile = (Mobile) gadgets.get(displayNumber);
            mobile.makeCall(phoneNumberTextField.getText(), Integer.parseInt(durationTextField.getText()));
            JOptionPane.showMessageDialog(this, "Call made successfully!", "Call Status", JOptionPane.INFORMATION_MESSAGE); // Shows when a call has been made successfully
        } else {
            JOptionPane.showMessageDialog(this, "Selected gadget is not a mobile or invalid display number.", "Error", JOptionPane.ERROR_MESSAGE); // Shows when a selected gadget is not a mobile
        }
    }

    
    private void downloadMusic() { // Method to download music to a selected MP3 gadget, if sufficient memory is available.
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1 && gadgets.get(displayNumber) instanceof MP3) {
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            mp3.downloadMusic(Integer.parseInt(downloadSizeTextField.getText()));
            JOptionPane.showMessageDialog(this, "Music downloaded successfully!", "Download Status", JOptionPane.INFORMATION_MESSAGE); // Shows when music is downloaded successfully.
        } else {
            JOptionPane.showMessageDialog(this, "Selected gadget is not an MP3 or invalid display number.", "Error", JOptionPane.ERROR_MESSAGE); //Prompts a return that the selected gadget is not a MP3
        }
    }

    
    private int getDisplayNumber() { // Takes the display number out of the input field and verifies it.
        try {
            int index = Integer.parseInt(displayNumberTextField.getText()) - 1; // Convert text to integer and adjust for zero-based index.
            if (index >= 0 && index < gadgets.size()) {
                return index; // Returns the valid index from the code.
            } else {
                JOptionPane.showMessageDialog(this, "Display number out of range.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return -1; // Returns -1 Indicates the out of range and input error notification.
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid display number format.", "Input Error", JOptionPane.ERROR_MESSAGE); // Returns a prompt that the data entered is invalid (display number)
            return -1; // Returns -1 indicates a formatting error as a message dialog pop-up.
        }
    }

    
    public static void main(String[] args) { // The primary means of starting the application.
        new GadgetShopGUI();
    }
}
