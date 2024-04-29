public class MP3 extends Gadget {
    private int availableMemory;

    public MP3(String model, double price, int weight, String size, int availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public int getAvailableMemory() {
        return availableMemory;
    }

    public void downloadMusic(int memorySize) {
        if (availableMemory >= memorySize) {
            availableMemory -= memorySize;
            System.out.println("Downloading music. " + memorySize + "MB used.");
            System.out.println("Remaining memory: " + availableMemory + "MB");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    public void deleteMusic(int memorySize) {
        availableMemory += memorySize;
        System.out.println("Deleting music. " + memorySize + "MB freed.");
        System.out.println("Remaining memory: " + availableMemory + "MB");
    }

    @Override
    public void display(int displayNumber) {
        System.out.println("Display Number: " + displayNumber);
        super.display(displayNumber); // Call the display method of the superclass (Gadget)
        System.out.println("Available Memory: " + availableMemory + "MB");
    }
}
