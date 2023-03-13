package src;

import src.entities.Car;
import src.entities.Customer;
import src.entities.Rental;

public class Controller {
    DBHandler dbHandler = new DBHandler();
    Input_Output inputOutput = new Input_Output();
    UI ui = new UI();
    boolean keepRunning = true;
    public static void main(String[] args) {
        new Controller().run();
    }

    public void run() {

        while (keepRunning) {
            mainMenu();
        }

    }

    public void menuSwitch(int choice) {
        switch (choice) {
            case 1 -> createRentalAgreement();
            case 2 -> createCar();
            case 3 -> createCustomer();
            case 4 -> getAllCars();
            case 5 -> getAllCustomers();
            case 6 -> getAllRentalAgreements();
            case 7 -> searchSpecificCustomer();
            case 8 -> deleteCustomer();
            case 9 -> deleteCar();
            case 10 -> keepRunning = false;
        }
    }

    public void viewMenu(){
        inputOutput.viewMenu.printMenu();
        switch (ui.readChoiceInt()){
            case 1 -> getAllRentalAgreements();
            case 2 -> getAllCars();
            case 3 -> getAllCustomers();
            case 4 -> createMenu();
            case 5 -> updateMenu();
            case 6 -> deleteMenu();
            case 7 -> searchMenu();
            case 9 -> mainMenu();
        }
    }

    public void createMenu(){
        inputOutput.createMenu.printMenu();
        switch (ui.readChoiceInt()){
            case 1 -> createRentalAgreement();
            case 2 -> createCar();
            case 3 -> createCustomer();
            case 4 -> updateMenu();
            case 5 -> deleteMenu();
            case 6 -> viewMenu();
            case 7 -> searchMenu();
            case 9 -> mainMenu();
        }
    }

    public void updateMenu(){
        inputOutput.updateMenu.printMenu();
        switch (ui.readChoiceInt()){
            case 1 -> updateContract();
            case 2 -> updateCar();
            case 3 -> updateCustomer();
            case 4 -> createMenu();
            case 5 -> deleteMenu();
            case 6 -> viewMenu();
            case 7 -> searchMenu();
            case 9 -> mainMenu();
        }
    }

    public void deleteMenu(){
        inputOutput.deleteMenu.printMenu();
        switch (ui.readChoiceInt()){
            case 1 -> deleteContract();
            case 2 -> deleteCar();
            case 3 -> deleteCustomer();
            case 4 -> createMenu();
            case 5 -> updateMenu();
            case 6 -> viewMenu();
            case 7 -> searchMenu();
            case 9 -> mainMenu();
        }
    }

    public void searchMenu(){
        inputOutput.searchMenu.printMenu();
        switch (ui.readChoiceInt()){
            case 1 -> searchSpecificContract();
            case 2 -> searchSpecificCar();
            case 3 -> searchSpecificCustomer();
            case 4 -> createMenu();
            case 5 -> updateMenu();
            case 6 -> deleteMenu();
            case 7 -> viewMenu();
            case 9 -> mainMenu();
        }
    }

    public void mainMenu(){
        inputOutput.mainMenu.printMenu();
        switch (ui.readChoiceInt()){
            case 1 -> createMenu();
            case 2 -> updateMenu();
            case 3 -> deleteMenu();
            case 4 -> viewMenu();
            case 5 -> searchMenu();
            case 9 -> keepRunning = false;
        }
    }

    /**
     * Uses customerInfo method from InputOutput class, to create a customer using addCustomerToDatabase method from dbHandler class
     */
    public void createCustomer() {
        String[] customerInfo = inputOutput.customerInfo();
        dbHandler.addCustomerToDatabase(new Customer(customerInfo[0], customerInfo[1], customerInfo[2], customerInfo[3],
                customerInfo[4], customerInfo[5], customerInfo[6], customerInfo[7], customerInfo[8]));
    }

    /**
     * Searches the database for specifik customer
     */
    public void searchSpecificCustomer() {
        inputOutput.printCustomers(dbHandler.querySpecificCustomer(inputOutput.specificInfo()));
    }

    public void searchSpecificCar(){
        inputOutput.printCars(dbHandler.querySpecificCar(inputOutput.specificInfo()));
    }

    public void searchSpecificContract(){
        inputOutput.printRentalAgreements(dbHandler.querySpecificRentalContract(inputOutput.specificInfo()));
    }

    /**
     * Method for deleting customer
     */
    public void deleteCustomer() {
        dbHandler.deleteCustomerFromDatabase(inputOutput.deleteCustomerInfo());
    }

    public void deleteCar() {
        dbHandler.deleteCarFromDatabase(inputOutput.deleteCarInfo());
        //todo create additional table for storing rental Contracts
    }

    public void deleteContract(){
        //todo create method
    }

    public void updateContract(){
        //todo create method
    }

    public void updateCar(){
        //todo create method
    }

    public void updateCustomer(){
        //todo create method
    }

    public void createCar(){
        String[] carInfo = inputOutput.carInfo();
        boolean isRented = false;
        if (carInfo[7].equalsIgnoreCase("yes")){
            isRented = true;
        }

        dbHandler.addCarDatabase(new Car(carInfo[0], carInfo[1], carInfo[2],
                carInfo[3], carInfo[4], Integer.parseInt(carInfo[5]), carInfo[6], isRented));
    }

    public void createRentalAgreement(){
        //todo make it easier to add since right now you need to enter a specifik driver license number and plate
        String[] rentalInfo = inputOutput.rentalAgreementInfo();

        dbHandler.addRentalDatabase(new Rental(rentalInfo[0], rentalInfo[1], Integer.parseInt(rentalInfo[2]),
                Integer.parseInt(rentalInfo[3]), Integer.parseInt(rentalInfo[4]), rentalInfo[5]));
    }

    public void getAllCars(){
        inputOutput.printCars(dbHandler.queryCar());
    }

    public void getAllCustomers(){
        inputOutput.printCustomers(dbHandler.queryCustomers());
    }

    public void getAllRentalAgreements(){
        inputOutput.printRentalAgreements(dbHandler.queryRentalContracts());
    }
}

