package src;

import src.entities.Car;

public class Controller {
    Output output = new Output();
    UI ui = new UI();
    DBHandler dbHandler = new DBHandler();

    public static void main(String[] args) {
        new Controller().run();
    }

    public void run() {

        /*int choice;
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
        }*/
        dbHandler.addCarDatabase(new Car("Mercedes", "E250", "Diesel", "AF23124", "2003-02-01", 12322, "Luxury", false));
        getAllCars();
    }

    public void getAllCars(){
        output.printCars(dbHandler.queryCar());

    }

}

