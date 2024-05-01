import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShopGUI extends JFrame implements ActionListener {
    // Fields for gadget attributes
    private JTextField modelTextField, priceTextField, weightTextField, sizeTextField,
            creditTextField, memoryTextField, phoneNumberTextField, durationTextField,
            downloadTextField, displayNumberTextField;
    
    // Buttons
    private JButton addMobileButton, addMP3Button, clearButton, displayAllButton,
            makeCallButton, downloadButton;

    // List to store gadgets
    private ArrayList<Gadget> gadgets;

    public GadgetShopGUI() {
        // Window setup
        setTitle("Gadget Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new FlowLayout());

        // Initialize UI components
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        modelTextField = new JTextField(10);
        priceTextField = new JTextField(10);
        weightTextField = new JTextField(10);
        sizeTextField = new JTextField(10);
        creditTextField = new JTextField(10);
        memoryTextField = new JTextField(10);
        phoneNumberTextField = new JTextField(10);
        durationTextField = new JTextField(10);
        downloadTextField = new JTextField(10);
        displayNumberTextField = new JTextField(10);

        // Add labels and text fields to the frame
        add(new JLabel("Model"));
        add(modelTextField);
        add(new JLabel("Price"));
        add(priceTextField);
        add(new JLabel("Weight"));
        add(weightTextField);
        add(new JLabel("Size"));
        add(sizeTextField);
        add(new JLabel("Credit for Mobile"));
        add(creditTextField);
        add(new JLabel("Memory for MP3"));
        add(memoryTextField);
        add(new JLabel("Phone Number"));
        add(phoneNumberTextField);
        add(new JLabel("Call Duration"));
        add(durationTextField);
        add(new JLabel("Download Size"));
        add(downloadTextField);
        add(new JLabel("Display Number"));
        add(displayNumberTextField);

        // Initialize buttons
        addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(this);
        add(addMobileButton);

        addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(this);
        add(addMP3Button);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton);

        displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(this);
        add(displayAllButton);

        makeCallButton = new JButton("Make a Call");
        makeCallButton.addActionListener(this);
        add(makeCallButton);

        downloadButton = new JButton("Download Music");
        downloadButton.addActionListener(this);
        add(downloadButton);

        gadgets = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMobileButton) {
            addMobile();
        } else if (e.getSource() == addMP3Button) {
            addMP3();
        } else if (e.getSource() == clearButton) {
            clearFields();
