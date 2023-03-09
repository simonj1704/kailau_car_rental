package src;

import src.entities.Car;
import src.entities.Customer;
import src.entities.Rental;

import java.util.Scanner;

public class Controller {
    Customer customer;
    DBHandler dbHandler = new DBHandler();
    Input_Output inputOutput = new Input_Output();
    UI ui = new UI();
    boolean keepRunning = true;
    public static void main(String[] args) {
        new Controller().run();
    }

    public void run() {


        getAllCars();
        while (keepRunning) {
            inputOutput.menu.printMenu();
            menuSwitch(ui.readChoiceInt());
        }

    }

    public void menuSwitch(int choice){
        switch (choice){
            case 1 -> createRentalAgreement();
            case 2 -> createCar();
            case 3 -> createCustomer();
            case 4 -> getAllCars();
            case 5 -> getAllCustomers();
            case 6 -> getAllRentalAgreements();
            case 9 -> keepRunning = false;
        }
    }

    public void createCustomer(){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter customer name:");
        String name = in.nextLine();
        System.out.println("Enter customer address:");
        String address = in.nextLine();
        System.out.println("Enter customer zip code");
        String zipCode = in.nextLine();
        System.out.println("Enter customer city");
        String city = in.nextLine();
        System.out.println("Enter customer mobile number");
        String mobileNumber = in.nextLine();
        System.out.println("Enter customer phone number");
        String phoneNumber = in.nextLine();
        System.out.println("Enter customer e-mail:");
        String emailAddress = in.nextLine();
        System.out.println("Enter customer drivers license number");
        String driversLicenseNumber = in.nextLine();
        System.out.println("Enter 'driver since date' in the format of YYYY-MM-DD");
        String driverSinceDate = in.nextLine();

        new Customer(name,address,zipCode,city,mobileNumber,phoneNumber,emailAddress,driversLicenseNumber, driverSinceDate);
    }

    /**
     * returns search parameter for querySpecificCustomer method
     * @return
     */
    public String searchSpecificCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter search parameter: (Part of name, drivers license number etc.");
        String searchParameter = in.nextLine();
        return searchParameter;
    }

    /**
     * returns search parameter for deleteCustomerFromDatabase method
     * @return
     */
    public String deleteCustomer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter customer drivers license:");
        String searchParameter = in.nextLine();
        return  searchParameter;
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

