import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GadgetShopGUI extends JFrame {
    private JLabel ModelLabel, PriceLabel, WeightLabel, SizeLabel, CreditLabel, MemoryLabel, PhoneNumberLabel, DurationLabel, DownloadLabel, DisplayNumberLabel;
    private JTextField ModelTextField, PriceTextField, WeightTextField, SizeTextField, CreditTextField, MemoryTextField, PhoneNumberTextField, DurationTextField, DownloadTextField, DisplayNumberTextField;
    private JButton AddMobileButton, AddMp3Button, ClearButton, DisplayAllButton, MakeACallButton, DownloadMusicButton;
    private ArrayList<Gadget> gadgets;

    public GadgetShopGUI() {
        setTitle("Gadget Shop GUI");
        setLayout(null);
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }

    private void initComponents() {
        gadgets = new ArrayList<>();

        // Initialize and set bounds for labels and text fields
        ModelLabel = new JLabel("Model:");
        ModelLabel.setBounds(10, 10, 80, 25);
        add(ModelLabel);
        ModelTextField = new JTextField();
        ModelTextField.setBounds(100, 10, 150, 25);
        add(ModelTextField);

        PriceLabel = new JLabel("Price:");
        PriceLabel.setBounds(10, 40, 80, 25);
        add(PriceLabel);
        PriceTextField = new JTextField();
        PriceTextField.setBounds(100, 40, 150, 25);
        add(PriceTextField);

        WeightLabel = new JLabel("Weight:");
        WeightLabel.setBounds(10, 70, 80, 25);
        add(WeightLabel);
        WeightTextField = new JTextField();
        WeightTextField.setBounds(100, 70, 150, 25);
        add(WeightTextField);

        SizeLabel = new JLabel("Size:");
        SizeLabel.setBounds(10, 100, 80, 25);
        add(SizeLabel);
        SizeTextField = new JTextField();
        SizeTextField.setBounds(100, 100, 150, 25);
        add(SizeTextField);

        CreditLabel = new JLabel("Credit:");
        CreditLabel.setBounds(10, 130, 80, 25);
        add(CreditLabel);
        CreditTextField = new JTextField();
        CreditTextField.setBounds(100, 130, 150, 25);
        add(CreditTextField);

        MemoryLabel = new JLabel("Memory:");
        MemoryLabel.setBounds(10, 160, 80, 25);
        add(MemoryLabel);
        MemoryTextField = new JTextField();
        MemoryTextField.setBounds(100, 160, 150, 25);
        add(MemoryTextField);

        // Initialize and set bounds for buttons
        AddMobileButton = new JButton("Add Mobile");
        AddMobileButton.setBounds(300, 10, 120, 25);
        AddMobileButton.addActionListener(this::addMobile);
        add(AddMobileButton);

        AddMp3Button = new JButton("Add MP3");
        AddMp3Button.setBounds(300, 40, 120, 25);
        AddMp3Button.addActionListener(this::addMp3);
        add(AddMp3Button);

        ClearButton = new JButton("Clear");
        ClearButton.setBounds(300, 70, 120, 25);
        ClearButton.addActionListener(e -> clearFields());
        add(ClearButton);

        DisplayAllButton = new JButton("Display All");
        DisplayAllButton.setBounds(300, 100, 120, 25);
        DisplayAllButton.addActionListener(e -> displayAll());
        add(DisplayAllButton);

        MakeACallButton = new JButton("Make a Call");
        MakeACallButton.setBounds(300, 130, 120, 25);
        MakeACallButton.addActionListener(e -> makeCall());
        add(MakeACallButton);

        DownloadMusicButton = new JButton("Download Music");
        DownloadMusicButton.setBounds(300, 160, 120, 25);
        DownloadMusicButton.addActionListener(e -> downloadMusic());
        add(DownloadMusicButton);
    }

    private void addMobile() {
        try {
            String model = ModelTextField.getText();
            double price = Double.parseDouble(PriceTextField.getText());
            int weight = Integer.parseInt(WeightTextField.getText());
            String size = SizeTextField.getText();
            int credit = Integer.parseInt(CreditTextField.getText());

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addMp3() {
        try {
            String model = ModelTextField.getText();
            double price = Double.parseDouble(PriceTextField.getText());
            int weight = Integer.parseInt(WeightTextField.getText());
            String size = SizeTextField.getText();
            int memory = Integer.parseInt(MemoryTextField.getText());

            MP3 mp3 = new MP3(model, price, weight, size, memory);
            gadgets.add(mp3);
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numeric values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        ModelTextField.setText("");
        PriceTextField.setText("");
        WeightTextField.setText("");
        SizeTextField.setText("");
        CreditTextField.setText("");
        MemoryTextField.setText("");
    }

    private void displayAll() {
        for (Gadget gadget : gadgets) {
            gadget.display(gadgets.indexOf(gadget) + 1);
        }
    }

    private void makeCall() {
        // Implementation of the method to make a call
    }

    private void downloadMusic() {
        // Implementation of the method to download music
    }

    public static void main(String[] args) {
        new GadgetShopGUI();
    }
}
