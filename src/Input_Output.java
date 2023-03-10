package src;

import src.entities.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class Input_Output {
    Menu menu = new Menu("---[Kailau Car Rental]---", "Make your choice: ", new String[]
            {"1. New Rental Contract", "2. Add New Vehicle", "3. Add New Customer", "4. View Car",
                    "5. View Customers", "6. View Rental Agreements", "7. Delete Car", "8. Delete "});

    Menu mainMenu = new Menu("---[Kailau Car Rental]---", "Make your choice: ", new String[]
            {"1. Create Menu", "2. Update Menu", "3. Delete Menu", "4. View Menu", "5. Search Menu",
                    "9. Exit Program"});

    Menu viewMenu = new Menu("---[View Menu]---", "Make your choice: ", new String[]
            {"1. View Rental Contracts", "2. View Vehicles", "3. View Customers", "4. Create Menu",
                    "5. Update Menu", "6. Delete Menu", "7. Search Menu", "9. Exit to Main Menu"});

    Menu createMenu = new Menu("---[Create Menu]---", "Make your choice: ", new String[]
            {"1. New Rental Contract", "2. Add New Vehicle", "3. Add New Customer", "4. Update Menu",
                    "5. Delete Menu", "6. View Menu", "7. Search Menu", "9. Exit to Menu"});

    Menu updateMenu = new Menu("---[Update Menu]---", "Make your choice: ", new String[]
            {"1. Update Rental Contract", "2. Update Vehicle", "3. Update Customer", "4. Create Menu",
                    "5. Delete Menu", "6. View Menu", "7. Search Menu", "9. Exit to Menu"});

    Menu deleteMenu = new Menu("---[Delete Menu]---", "Make your choice: ", new String[]
            {"1. Delete Rental Contract", "2. Delete Vehicle", "3. Delete Customer", "4. Create Menu",
                    "5. Delete Menu", "6. View Menu", "7. Search Menu", "9. Exit to Menu"});

    Menu searchMenu = new Menu("---[Search Menu]---", "Make your choice: ", new String[]
            {"1. Search Rental Contract", "2. Search Vehicle", "3. Search Customer", "4. Create Menu",
                    "5. Update Menu", "6. Delete Menu", "7. View Menu", "9. Exit to Menu"});

    UI ui = new UI();
    Scanner in = new Scanner(System.in);

    public void printLine(String message) {
        System.out.println(message);
    }

    public void print(String message) {
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

    public String[] rentalAgreementInfo() {
        String[] rentalInfo = new String[6];

        System.out.print("CREATE RENTAL AGREEMENT");

        System.out.print("\nEnter Start Date of Rental Agreement: \n");
        rentalInfo[0] = ui.readDate();
        System.out.println("From " + rentalInfo[0]);
        System.out.print("\nEnter End Date of Rental Agreement: \n");
        rentalInfo[1] = ui.readDate();
        System.out.println("From " + rentalInfo[0] + " To " + rentalInfo[1]);
        System.out.print("\nEnter Driver License Number of Customer: ");
        rentalInfo[2] = "" + ui.readChoiceInt();
        System.out.print("\nEnter Max Kilometer of Rental Agreement: ");
        rentalInfo[3] = "" + ui.readChoiceInt();
        System.out.print("\nEnter Kilometer of Vehicle: ");
        rentalInfo[4] = "" + ui.readChoiceInt();
        System.out.print("\nEnter Car Registration Number: ");
        rentalInfo[5] = in.nextLine();

        return rentalInfo;
    }

    /**
     * This method is used for getting all the info for creating a car from the user.
     *
     * @return array of String with info to create a car
     */
    public String[] carInfo() {
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
        carInfo[5] = "" + in.nextInt();
        in.nextLine();
        System.out.print("\nEnter Type of Vehicle: ");
        carInfo[6] = in.nextLine();
        System.out.print("\nIs Car already rented? (Yes)(No): ");
        String rentChoice = in.nextLine();
        while (!rentChoice.equalsIgnoreCase("yes") && !rentChoice.equalsIgnoreCase("no")) {
            System.out.print("Please input either Yes or No: ");
            rentChoice = in.nextLine();
        }
        carInfo[7] = rentChoice;
        return carInfo;
    }

    public void printCars(ArrayList<Car> cars) {
        System.out.printf("%-10s\t %-10s\t %-10s\t %-8s\t %-9s\t %-8s\t %-7s\t %s\n",
                "Reg. Number", "Model", "Brand", "Reg. Year", "Fuel Type", "Car Type", "Odometer", "Rented");
        for (int i = 0; i < cars.size(); i++) {
            System.out.printf("%-10s\t %-10s\t %-10s\t %-8s\t %-9s\t %-8s\t %-7d\t %b\n",
                    cars.get(i).getRegistrationNumber(), cars.get(i).getModel(), cars.get(i).getBrand(),
                    cars.get(i).getRegistrationYear(), cars.get(i).getFuelType(), cars.get(i).getType(),
                    cars.get(i).getOdometer(), cars.get(i).isRented());
        }
    }

    public void printCustomers(String customers) {
        System.out.println("Driver License Number\t Name\t Mobile Number\t Phone Number\t Email\t " +
                "Driver Since Date\t Address\t ZIP\t City");
        System.out.println(customers);
    }

    public void printRentalAgreements(String contracts) {
        System.out.println("ID\t From Date\t To Date\t Max Km\t Km on Car\t " +
                "Driver License number\t Registration Number");
        System.out.println(contracts);
    }


}