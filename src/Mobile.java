public class Mobile extends Gadget {
    private int credit;

    public Mobile(String model, double price, int weight, String size, int credit) {
        super(model, price, weight, size);
        this.credit = credit;
    }

    public void addCredit(int additionalCredit) {
        if (additionalCredit > 0) {
            credit += additionalCredit;
            System.out.println("Credit added. Total credit: " + credit + " minutes.");
        } else {
            System.out.println("Error: Credit not added. Please add a positive amount.");
        }
    }

    public void makeCall(String phoneNumber, int duration) {
        if (credit >= duration) {
            credit -= duration;
            System.out.println("Call made to " + phoneNumber + " for " + duration + " minutes. Remaining credit: " + credit + " minutes.");
        } else {
            System.out.println("Insufficient credit.");
        }
    }

    @Override
    public void display(int displayNumber) {
        super.display(displayNumber); // Calls the display method from Gadget class, passing the display number
        System.out.println("Credit: " + credit + " minutes."); // Then adds specific details for Mobile
    }
}
