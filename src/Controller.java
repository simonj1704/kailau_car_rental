package src;

import src.entities.Customer;

import java.util.Scanner;

public class Controller {
    Customer customer;
    DBHandler dbHandler = new DBHandler();
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
    public void getAllCars(){
        output.printCars(dbHandler.queryCar());
    }
}

