package src;

public class Controller {
    Menu menu = new Menu();
    public static void main(String[] args) {
        new Controller().run();
    }

    public void run() {
        int choice;
        menu.menu.printMenu();
        choice = menu.ui.readChoiceInt();

        switch (choice) {
            case 1:
                System.out.println("You've selected: New Rental Contract.");
                break;
            case 2:
                System.out.println("You've selected: Add new Vehicle. ");
                menu.createNewVehicle();
                break;
            case 3:
                System.out.println("You selected Strawberry");
                break;
        }
    }

}

