package src;

public class Controller {
    Output output = new Output();
    public static void main(String[] args) {
        new Controller().run();
    }

    public void run() {
        int choice;
        output.menu.printMenu();
        choice = output.ui.readChoiceInt();

        switch (choice) {
            case 1:
                System.out.println("You've selected: New Rental Contract.");
                output.createRentalAgreement();
                break;
            case 2:
                System.out.println("You've selected: Add new Vehicle. ");
                output.createNewVehicle();
                break;
            case 3:
                System.out.println("You've selected: Add new Customer.");
                // WIP
                break;
        }
    }

}

