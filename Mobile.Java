public class Mobile extends Gadget {
    private int callingCredit;

    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size);
        this.callingCredit = callingCredit;
    }

    public int getCallingCredit() {
        return callingCredit;
    }

    public void addCredit(int credit) {
        if (credit > 0) {
            callingCredit += credit;
            System.out.println(credit + " minutes of credit added. Total credit now: " + callingCredit + " minutes.");
        } else {
            System.out.println("Invalid amount. Please enter a positive amount of credit.");
        }
    }

    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            callingCredit -= duration;
            System.out.println("Call made to " + phoneNumber + " for " + duration + " minutes.");
            System.out.println("Remaining credit: " + callingCredit + " minutes.");
        } else {
            System.out.println("Insufficient credit to make the call.");
        }
    }

    @Override
    public void display(int displayNumber) {
        System.out.println("Display Number: " + displayNumber);
        super.display(displayNumber); // Call the display method of the superclass (Gadget)
        System.out.println("Calling Credit: " + callingCredit + " minutes");
    }
}
