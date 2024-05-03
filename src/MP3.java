/** 

* Gadget Shop application for adding MP3 Players, Mobile/Smart Phones, making calls and downloading music. 

* 

* @author (Nadir Omer Ahmed Ismail) 

* @version (03/05/2024) 

*/ 



public class MP3 extends Gadget {
    private double availableMemory;

    public MP3(String model, double price, int weight, String size, double availableMemory) {
        super(model, price, weight, size);
        this.availableMemory = availableMemory;
    }

    public double getAvailableMemory() {
        return availableMemory;
    }

    public void downloadMusic(double size) {
        if (size <= availableMemory) {
            availableMemory -= size;
            System.out.println("Downloaded " + size + "MB of music.");
        } else {
            System.out.println("Insufficient memory to download music.");
        }
    }

    public void deleteMusic(double size) {
        availableMemory += size;
        System.out.println("Deleted " + size + "MB of music, freeing up space.");
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Available Memory: " + availableMemory + "MB");
    }
}


