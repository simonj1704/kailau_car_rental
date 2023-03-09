package src;

import src.entities.Car;
import src.entities.Rental;

import java.util.Scanner;

public class Input_Output {
    Menu menu = new Menu("---[Kailau Car Rental]---", "Make your choice: ",new String[]
            {"1. New Rental Contract", "2. Add New Vehicle", "3. Add New Customer", "4. View Car", "5. View Customers"});

    Menu mainMenu = new Menu("---[Kailau Car Rental]---", "Make your choice: ",new String[]
            {"1. Create/Update Menu", "2. View Menu", "9. Exit Program"});

    Menu viewMenu = new Menu("---[View Menu]---", "Make your choice: ",new String[]
            {"1. View Rental Contracts", "2. View Cars", "3. View Customers", "4. Search for Contracts",
            "5. Search for Cars", "6. Search for Customers", "9. Exit to Menu"});

    Menu createMenu = new Menu("---[Create/Update Menu]---", "Make your choice: ",new String[]
            {"1. New Rental Contract", "2. Add New Vehicle", "3. Add New Customer", "4. Update Rental Contracts",
                    "5. Update Vehicles", "6. Update Customers", "9. Exit to Menu"});


    UI ui = new UI();
    Scanner in = new Scanner(System.in);

    public void printLine(String message){
        System.out.println(message);
    }
    public void print(String message){
        System.out.print(message);
    }

    public void createNewVehicle(String isRentedChoice, int odometer) {
        boolean approvedChoice = false;
        boolean isRented = false;


        System.out.print("\nIs Car already rented? (Yes)(No): ");
        isRentedChoice = in.nextLine();
        isRentedChoice = isRentedChoice.toLowerCase();

        while (!approvedChoice) {
            if (isRentedChoice.equals("yes") || isRentedChoice.equals("no")) {
                if (isRentedChoice.equals("yes")) {
                    isRented = true;
                    approvedChoice = true;
                } else if (isRentedChoice.equals("no")) {
                    isRented = false;
                    approvedChoice = true;
                } else {
                    System.out.println("Unknown Input, try again (Yes or No)");
                }
            }
        }


    }

    public void createRentalAgreement() {
        String name;
        String address;
        int zipCode;
        String city;
        String fromDate;
        String toDate;
        int driverLicenseNumber;
        int maxKm;
        int km;
        String carRegistrationNumber;

        System.out.print("\nYou've selected to create New Rental Agreement.");
        System.out.print("\nEnter Name of Customer: ");
        name = in.nextLine();
        System.out.print("\nEnter Address of Customer: ");
        address = in.nextLine();
        System.out.print("\nEnter Zip Code of Customer: ");
        zipCode = ui.readChoiceInt();
        System.out.print("\nEnter City corresponding with Zip Code: ");
        city = in.nextLine();
        System.out.print("\nEnter Start Date of Rental Agreement: ");
        fromDate = in.nextLine();
        System.out.print("\nEnter End Date of Rental Agreement: ");
        toDate = in.nextLine();
        System.out.print("\nEnter Driver License Number of Customer: ");
        driverLicenseNumber = ui.readChoiceInt();
        System.out.print("\nEnter Max Kilometer of Rental Agreement: ");
        maxKm = ui.readChoiceInt();
        System.out.print("\nEnter Kilometer of Vehicle: ");
        km = ui.readChoiceInt();
        System.out.print("\nEnter Car Registration Number: ");
        carRegistrationNumber = in.nextLine();

        Rental rentalAgreement = new Rental(fromDate,toDate,driverLicenseNumber,maxKm,km,carRegistrationNumber);
        // Send agreement to DB and print out?
    }

    public void printCars(String cars){
        System.out.println("Registration Number\t Model\t Brand\t Registration Year\t Fuel Type\t Car Type\t Odometer\t Rented");
        System.out.println(cars);
    }

    public void printCustomers(String customers){
        System.out.println("Driver License Number\t Name\t Mobile Number\t Phone Number\t Email\t " +
                "Driver Since Date\t Address\t ZIP\t City");
        System.out.println(customers);
    }

    /**
     * This method is used for getting all the info for creating a car from the user.
     * @return array of String with info to create a car
     */
    public String[] carInfo(){
        //todo make better scanner check
        String[] carInfo = new String[8];

        System.out.println("CREATE CAR");

        System.out.print("\nEnter Brand of Vehicle: ");
        carInfo[0] = in.nextLine();
        System.out.print("\nEnter Model of Vehicle: ");
        carInfo[1] = in.nextLine();
        System.out.print("\nEnter Fuel Type of Vehicle: ");
        carInfo[2] = in.nextLine();
        System.out.print("\nEnter the Registration Number of the Vehichle: ");
        carInfo[3] = in.nextLine();
        System.out.print("\nEnter Registration Year of Vehicle: ");
        carInfo[4] = in.nextLine() + "-01-01";
        System.out.println("\nEnter the amount of KM on the Vehicle: ");
        carInfo[5] = ""+in.nextInt();
        in.nextLine();
        System.out.print("\nEnter Type of Vehicle: ");
        carInfo[6] = in.nextLine();
        System.out.print("\nIs Car already rented? (Yes)(No): ");
        String rentChoice = in.nextLine();
        while (!rentChoice.equalsIgnoreCase("yes") && !rentChoice.equalsIgnoreCase("no")){
            System.out.print("Please input either Yes or No: ");
            rentChoice = in.nextLine();
        }
        carInfo[7] = rentChoice;
        return carInfo;
    }
}