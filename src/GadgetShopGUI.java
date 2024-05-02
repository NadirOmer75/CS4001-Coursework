import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShop implements ActionListener {

    private JFrame frame;
    private JTextField modelTextField, priceTextField, weightTextField, sizeTextField,
        creditTextField, memoryTextField, phoneNumberTextField, durationTextField, downloadTextField, displayNumberTextField;
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadButton;
    private ArrayList<Gadget> gadgets = new ArrayList<>();

    public GadgetShop() {
        makeFrame();
    }

    private void makeFrame() {
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(7, 4));

        contentPane.add(new JLabel("Model:"));
        modelTextField = new JTextField(15);
        contentPane.add(modelTextField);

        contentPane.add(new JLabel("Price:"));
        priceTextField = new JTextField(15);
        contentPane.add(priceTextField);

        contentPane.add(new JLabel("Weight:"));
        weightTextField = new JTextField(15);
        contentPane.add(weightTextField);

        contentPane.add(new JLabel("Size:"));
        sizeTextField = new JTextField(15);
        contentPane.add(sizeTextField);

        contentPane.add(new JLabel("Credit:"));
        creditTextField = new JTextField(15);
        contentPane.add(creditTextField);

        contentPane.add(new JLabel("Memory:"));
        memoryTextField = new JTextField(15);
        contentPane.add(memoryTextField);

        contentPane.add(new JLabel("Phone Number:"));
        phoneNumberTextField = new JTextField(15);
        contentPane.add(phoneNumberTextField);

        contentPane.add(new JLabel("Duration:"));
        durationTextField = new JTextField(15);
        contentPane.add(durationTextField);

        contentPane.add(new JLabel("Download:"));
        downloadTextField = new JTextField(15);
        contentPane.add(downloadTextField);

        contentPane.add(new JLabel("Display Number:"));
        displayNumberTextField = new JTextField(15);
        contentPane.add(displayNumberTextField);

        addMobileButton = new JButton("Add Mobile");
        contentPane.add(addMobileButton);
        addMobileButton.addActionListener(this);

        addMP3Button = new JButton("Add MP3");
        contentPane.add(addMP3Button);
        addMP3Button.addActionListener(this);

        clearButton = new JButton("Clear");
        contentPane.add(clearButton);
        clearButton.addActionListener(this);

        displayAllButton = new JButton("Display All");
        contentPane.add(displayAllButton);
        displayAllButton.addActionListener(this);

        makeCallButton = new JButton("Make a Call");
        contentPane.add(makeCallButton);
        makeCallButton.addActionListener(this);

        downloadButton = new JButton("Download Music");
        contentPane.add(downloadButton);
        downloadButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
    }

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

    private void addMobile() {
        try {
            Mobile mobile = new Mobile(getModel(), getPrice(), getWeight(), getSize(), getCredit());
            gadgets.add(mobile);
            JOptionPane.showMessageDialog(frame, "New Mobile Phone Added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for price, weight, and credit.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addMP3() {
        try {
            MP3 mp3 = new MP3(getModel(), getPrice(), getWeight(), getSize(), getMemory());
            gadgets.add(mp3);
            JOptionPane.showMessageDialog(frame, "New MP3 Added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for price, weight, and memory.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clear() {
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        creditTextField.setText("");
        memoryTextField.setText("");
        phoneNumberTextField.setText("");
        durationTextField.setText("");
        downloadTextField.setText("");
        displayNumberTextField.setText("");
    }

    private void displayAll() {
        gadgets.forEach(gadget -> System.out.println(gadget));
    }

    private void makeCall() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1 && gadgets.get(displayNumber) instanceof Mobile) {
            Mobile mobile = (Mobile) gadgets.get(displayNumber);
            mobile.makeCall(getPhoneNumber(), getDuration());
        } else {
            JOptionPane.showMessageDialog(frame, "Selected gadget is not a mobile or invalid display number.", "Operation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void downloadMusic() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1 && gadgets.get(displayNumber) instanceof MP3) {
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            mp3.downloadMusic(getDownload());
        } else {
            JOptionPane.showMessageDialog(frame, "Selected gadget is not an MP3 player or invalid display number.", "Operation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getModel() {
        return modelTextField.getText();
    }

    private double getPrice() {
        return Double.parseDouble(priceTextField.getText());
    }

    private int getWeight() {
        return Integer.parseInt(weightTextField.getText());
    }

    private String getSize() {
        return sizeTextField.getText();
    }

    private int getCredit() {
        return Integer.parseInt(creditTextField.getText());
    }

    private int getMemory() {
        return Integer.parseInt(memoryTextField.getText());
    }

    private String getPhoneNumber() {
        return phoneNumberTextField.getText();
    }

    private int getDuration() {
        return Integer.parseInt(durationTextField.getText());
    }

    private int getDownload() {
        return Integer.parseInt(downloadTextField.getText());
    }

    private int getDisplayNumber() {
        try {
            int displayNumber = Integer.parseInt(displayNumberTextField.getText()) - 1;
            if (displayNumber < 0 || displayNumber >= gadgets.size()) {
                throw new IllegalArgumentException("Invalid display number.");
            }
            return displayNumber;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Display Number must be an integer.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
}
