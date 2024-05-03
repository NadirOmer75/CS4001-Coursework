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
            System.out.println("Music downloaded successfully. Remaining memory: " + availableMemory + " MB.");
        } else {
            System.out.println("Error: Not enough memory to download the music.");
        }
    }

    public void deleteMusic(int memorySize) {
        availableMemory += memorySize;
        System.out.println("Music deleted successfully. Available memory is now: " + availableMemory + " MB.");
    }

    @Override
    public void display(int displayNumber) {
        super.display(displayNumber); // Now passing displayNumber to the superclass display method
        System.out.println("Available Memory: " + availableMemory + " MB.");
    }
}
