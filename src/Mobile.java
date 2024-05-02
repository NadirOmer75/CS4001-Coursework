// Mobile class extends the Gadget class to include features specific to mobile phones, such as calling credits.
public class Mobile extends Gadget {
    // Private instance variable to store the calling credit amount in minutes.
    private int callingCredit;

    // Constructor for the Mobile class, includes initialization for model, price, weight, size, and calling credit.
    public Mobile(String model, double price, int weight, String size, int callingCredit) {
        super(model, price, weight, size); // Calls the superclass constructor to initialize common gadget attributes.
        this.callingCredit = callingCredit; // Initializes the calling credit for the mobile phone.
    }

    // Getter method to retrieve the current calling credit amount.
    public int getCallingCredit() {
        return callingCredit;
    }

    // Method to add calling credit to the mobile phone. The credit amount must be positive.
    public void addCredit(int credit) {
        if (credit > 0) {
            callingCredit += credit; // Adds the specified amount of credit to the existing credit.
            System.out.println(credit + " minutes of credit added. Total credit now: " + callingCredit + " minutes.");
        } else {
            System.out.println("Invalid amount. Please enter a positive amount of credit."); // Error message for invalid input.
        }
    }

    // Method to make a phone call, decreasing the calling credit by the duration of the call if sufficient credit exists.
    public void makeCall(String phoneNumber, int duration) {
        if (callingCredit >= duration) {
            callingCredit -= duration; // Deducts the call duration from the available credit.
            System.out.println("Call made to " + phoneNumber + " for " + duration + " minutes.");
            System.out.println("Remaining credit: " + callingCredit + " minutes."); // Displays the remaining credit after the call.
        } else {
            System.out.println("Insufficient credit to make the call."); // Error message if there's not enough credit to make the call.
        }
    }

    public void display(int displayNumber) {
        System.out.println("Display Number: " + displayNumber); // Outputs the display number assigned to this gadget.
        super.display(displayNumber); // Calls the display method of the superclass to print basic gadget details.
        System.out.println("Calling Credit: " + callingCredit + " minutes"); // Outputs the available calling credit.
    }
}
