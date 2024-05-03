// MP3 class that extends the Gadget base class
public class MP3 extends Gadget {
    // Private attribute to store the available memory on the MP3 player
    private int availableMemory;

    // Constructor for the MP3 class
    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size); // Calls the superclass constructor to initialize common attributes
        this.availableMemory = availableMemory; // Initialize the specific attribute of the MP3 class
    }

    // Getter method to access the available memory
    public int getAvailableMemory() {
        return availableMemory;
    }

    // Method to download music which decreases the available memory if there is enough memory available
    public void downloadMusic(int memorySize) {
        if (availableMemory >= memorySize) {
            availableMemory -= memorySize; // Deduct the memory size from available memory
            System.out.println("Music downloaded successfully. Remaining memory: " + availableMemory + " MB."); // Success message
        } else {
            System.out.println("Error: Not enough memory to download the music."); // Error message if not enough memory
        }
    }

    // Method to delete music which increases the available memory
    public void deleteMusic(int memorySize) {
        availableMemory += memorySize; // Add the memory size back to available memory
        System.out.println("Music deleted successfully. Available memory is now: " + availableMemory + " MB."); // Confirmation message
    }

    // Overridden display method to show details about the MP3 player along with its memory
    @Override
    public void display(int displayNumber) {
        super.display(displayNumber); // Call to the superclass method to display common gadget info
        System.out.println("Available Memory: " + availableMemory + " MB."); // Display specific info about MP3 memory
    }
}
