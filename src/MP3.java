// MP3 class extends the Gadget class to add specific functionalities for MP3 devices
public class MP3 extends Gadget {
    // Instance variable to store the available memory of the MP3 device in megabytes
    private int availableMemory;

    // Constructor for MP3 class, calls the superclass constructor to initialize common gadget attributes
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size); // Superclass constructor call to set model, price, weight, and size
        this.availableMemory = availableMemory; // Initialize the availableMemory specific to MP3
    }

    // Getter method to return the available memory of the MP3 device
    public int getAvailableMemory() {
        return availableMemory;
    }

    // Method to download music, reducing the available memory
    public void downloadMusic(int memorySize) {
        if (availableMemory >= memorySize) {
            availableMemory -= memorySize; // Reduce available memory by the size of the music to be downloaded
            System.out.println("Downloading music. " + memorySize + "MB used."); // Confirmation message
            System.out.println("Remaining memory: " + availableMemory + "MB"); // Display remaining memory
        } else {
            System.out.println("Insufficient memory to download music."); // Error message if memory is insufficient
        }
    }

    // Method to delete music, increasing the available memory
    public void deleteMusic(int memorySize) {
        availableMemory += memorySize; // Increase available memory by the size of the music deleted
        System.out.println("Deleting music. " + memorySize + "MB freed."); // Confirmation message
        System.out.println("Remaining memory: " + availableMemory + "MB"); // Display remaining memory
    }

    // Override the display method of Gadget to include details about available memory
    @Override
    public void display(int displayNumber) {
        System.out.println("Display Number: " + displayNumber); // Display the identifier number of the gadget
        super.display(displayNumber); // Call the display method of the superclass (Gadget)
        System.out.println("Available Memory: " + availableMemory + "MB"); // Display the available memory
    }
}
