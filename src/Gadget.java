// Define a class named Gadget to store details about different gadgets
public class Gadget {
    // Declare private instance variables for the Gadget class
    private String model; // Store the model name of the gadget
    private double price; // Store the price of the gadget in pounds
    private int weight; // Store the weight of the gadget in grams
    private String size; // Store the size description of the gadget

    // Constructor to initialize a new Gadget object with model, price, weight, and size
    public Gadget(String model, double price, int weight, String size) {
        this.model = model; // Assign the model name to the instance variable
        this.price = price; // Assign the price to the instance variable
        this.weight = weight; // Assign the weight to the instance variable
        this.size = size; // Assign the size to the instance variable
    }

    // Getter method to return the model of the gadget
    public String getModel() {
        return model;
    }

    // Getter method to return the price of the gadget
    public double getPrice() {
        return price;
    }

    // Getter method to return the weight of the gadget
    public int getWeight() {
        return weight;
    }

    // Getter method to return the size of the gadget
    public String getSize() {
        return size;
    }

    // Method to display the details of the gadget
    public void display(int displayNumber) {
        System.out.println("Model: " + model); // Output the model to the console
        System.out.println("Price: £" + price); // Output the price to the console
        System.out.println("Weight: " + weight + "g"); // Output the weight to the console
        System.out.println("Size: " + size); // Output the size to the console
    }
}
