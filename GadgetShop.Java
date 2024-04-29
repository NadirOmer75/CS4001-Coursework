import java.util.ArrayList;

public class GadgetShop {
    private ArrayList<Gadget> gadgets;

    public GadgetShop() {
        gadgets = new ArrayList<>();
    }

    public void addGadget(Gadget gadget) {
        gadgets.add(gadget);
    }

    public void displayGadgets() {
        for (int i = 0; i < gadgets.size(); i++) {
            gadgets.get(i).display(i + 1); // Pass the display number
            System.out.println(); // Add a blank line between gadgets
        }
    }
    
    public static void main(String[] args) {
        GadgetShop shop = new GadgetShop();
        shop.addGadget(new Mobile("iPhone 12", 799.99, 162, "6.1 inches", 120));
        shop.addGadget(new MP3("Sony Walkman", 299.99, 70, "3 inches", 32));
        shop.displayGadgets();
    }
}
