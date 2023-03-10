package src;

import src.entities.Car;
import src.entities.Customer;
import src.entities.Rental;

import java.util.ArrayList;
import java.util.Scanner;

public class Input_Output {
    Menu menu = new Menu("---[Kailau Car Rental]---", "Make your choice: ", new String[]
            {"1. New Rental Contract", "2. Add New Vehicle", "3. Add New Customer", "4. View Car",
                    "5. View Customers", "6. View Rental Agreements", "7. Search for customer", "8. Delete Customer ",
                    "9. Delete car", "10. End program"});
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


    /**
     * @return search parameter for deleteCustomerFromDatabase method
     */
    public String deleteCustomerInfo() {
        System.out.println("Please enter customer drivers license:");
        return in.nextLine();
    }

    public String[] customerInfo() {
        String[] customerInfo = new String[9];

        System.out.println("Enter customer name:");
        customerInfo[0] = in.nextLine();
        System.out.println("Enter customer address:");
        customerInfo[1] = in.nextLine();
        System.out.println("Enter customer zip code");
        customerInfo[2] = in.nextLine();
        System.out.println("Enter customer city");
        customerInfo[3] = in.nextLine();
        System.out.println("Enter customer mobile number");
        customerInfo[4] = in.nextLine();
        System.out.println("Enter customer phone number");
        customerInfo[5] = in.nextLine();
        System.out.println("Enter customer e-mail:");
        customerInfo[6] = in.nextLine();
        System.out.println("Enter customer drivers license number");
        customerInfo[7] = in.nextLine();
        System.out.println("Enter 'driver since date' in the format of YYYY-MM-DD");
        customerInfo[8] = ui.readDate();

        return customerInfo;
    }

    /**
     * returns search parameter for querySpecificCustomer method
     * @return search parameter
     */
    public String specificInfo() {
        System.out.println("Please enter search parameter: (Part of name, drivers license number etc.)");
        return in.nextLine();
    }

    public String deleteCarInfo() {
        System.out.println("Please enter car registration number:");
        return in.nextLine();
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

    public void printCustomers(ArrayList<Customer> customers) {
        System.out.printf("%-15s\t %-15s\t %-12s\t %-12s\t %-20s\t %-12s\t %-15s\t %-5s\t %-10s\n",
                "License Number", "Name", "Mobile Number", "Phone Number", "Email",
                "Driver Since", "Address", "ZIP", "City");
        for (int i = 0; i < customers.size(); i++) {
            System.out.printf("%-15s\t %-15s\t %-12s\t %-12s\t %-20s\t %-12s\t %-15s\t %-5s\t %-10s\n",
                    customers.get(i).getDriversLicenseNumber(), customers.get(i).getName(),
                    customers.get(i).getMobileNumber(), customers.get(i).getPhoneNumber(),
                    customers.get(i).getEmail(),customers.get(i).getDriverSinceDate(),
                    customers.get(i).getAddress(),customers.get(i).getZipCode(),
                    customers.get(i).getCity());
        }
    }

    public void printRentalAgreements(ArrayList<Rental> contracts) {
        System.out.println("ID\t From Date\t To Date\t Max Km\t Km on Car\t " +
                "Driver License number\t Customer Name\t Registration Number");
        for (int i = 0; i < contracts.size(); i++) {
            System.out.println(contracts.get(i));
        }
    }


}