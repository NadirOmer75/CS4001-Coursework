// GadgetShop manages a list of gadgets and provides a GUI for interacting with those gadgets.
public class GadgetShop implements ActionListener {

    // Declaration of frame and multiple text fields for gadget attributes and actions
    private JFrame frame;
    private JTextField modelTextField, priceTextField, weightTextField, sizeTextField,
        creditTextField, memoryTextField, phoneNumberTextField, durationTextField, downloadTextField, displayNumberTextField;

    // Buttons for various functionalities like adding mobiles, MP3s, clearing fields, etc.
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton, makeCallButton, downloadButton;

    // List to store all gadgets added
    private ArrayList<Gadget> gadgets = new ArrayList<>();

    // Constructor for GadgetShop
    public GadgetShop() {
        makeFrame();
    }

    // Creates the main GUI frame
    private void makeFrame() {
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(7, 4));

        // Adding labels and corresponding text fields for gadget attributes to the GUI
        addFieldWithLabel(contentPane, "Model:", modelTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Price:", priceTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Weight:", weightTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Size:", sizeTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Credit:", creditTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Memory:", memoryTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Phone Number:", phoneNumberTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Duration:", durationTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Download:", downloadTextField = new JTextField(15));
        addFieldWithLabel(contentPane, "Display Number:", displayNumberTextField = new JTextField(15));

        // Adding buttons and setting their action listeners
        addButtonWithListener(contentPane, "Add Mobile", addMobileButton = new JButton());
        addButtonWithListener(contentPane, "Add MP3", addMP3Button = new JButton());
        addButtonWithListener(contentPane, "Clear", clearButton = new JButton());
        addButtonWithListener(contentPane, "Display All", displayAllButton = new JButton());
        addButtonWithListener(contentPane, "Make a Call", makeCallButton = new JButton());
        addButtonWithListener(contentPane, "Download Music", downloadButton = new JButton());

        frame.pack();
        frame.setVisible(true);
    }

    // Handles user actions from the GUI
    public void actionPerformed(ActionEvent event) {
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
    }

    // Adds a mobile gadget
    private void addMobile() {
        try {
            Mobile mobile = new Mobile(getModel(), getPrice(), getWeight(), getSize(), getCredit());
            gadgets.add(mobile);
            JOptionPane.showMessageDialog(frame, "New Mobile Phone Added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for price, weight, and credit.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Adds an MP3 gadget
    private void addMP3() {
        try {
            MP3 mp3 = new MP3(getModel(), getPrice(), getWeight(), getSize(), getMemory());
            gadgets.add(mp3);
            JOptionPane.showMessageDialog(frame, "New MP3 Added!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid numbers for price, weight, and memory.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clears all text fields
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

    // Displays all gadgets
    private void displayAll() {
        gadgets.forEach(gadget -> System.out.println(gadget));
    }

    // Initiates a call from a mobile gadget
    private void makeCall() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1 && gadgets.get(displayNumber) instanceof Mobile) {
            Mobile mobile = (Mobile) gadgets.get(displayNumber);
            mobile.makeCall(getPhoneNumber(), getDuration());
        } else {
            JOptionPane.showMessageDialog(frame, "Selected gadget is not a mobile or invalid display number.", "Operation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Downloads music to an MP3 gadget
    private void downloadMusic() {
        int displayNumber = getDisplayNumber();
        if (displayNumber != -1 && gadgets.get(displayNumber) instanceof MP3) {
            MP3 mp3 = (MP3) gadgets.get(displayNumber);
            mp3.downloadMusic(getDownload());
        } else {
            JOptionPane.showMessageDialog(frame, "Selected gadget is not an MP3 player or invalid display number.", "Operation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Helper methods to get values from text fields
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
