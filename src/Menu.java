package src;

import src.entities.Car;
import src.entities.Rental;

import java.util.Scanner;

public class Menu {
    GenericMenu menu = new GenericMenu("---[Kailau Car Rental]---", "Make your choice: ",new String[] {"1. New Rental Contract", "2. Add New Vehicle", "3. Add New Customer"});
    UI ui = new UI();
    Scanner in = new Scanner(System.in);

    public void createNewVehicle() {
        System.out.println("\nYou've selected to Create new Vehicle:");
        String brand;
        String model;
        String fuelType;
        String registrationNumber;
        String registrationYear;
        String type;
        String isRentedChoice;
        int odometer;
        boolean approvedChoice = false;
        boolean isRented = false;

        System.out.print("\nEnter Brand of Vehicle: ");
        brand = in.nextLine();
        System.out.print("\nEnter Model of Vehicle: ");
        model = in.nextLine();
        System.out.print("\nEnter Fuel Type of Vehicle: ");
        fuelType = in.nextLine();
        System.out.print("\nEnter the Registration Number of the Vehichle: ");
        registrationNumber = in.nextLine();
        System.out.print("\nEnter Registration Year of Vehicle: ");
        registrationYear = in.nextLine();
        System.out.println("\nEnter the amount of KM on the Vehicle: ");
        odometer = in.nextInt();
        in.nextLine();
        System.out.print("\nEnter Type of Vehicle: ");
        type = in.nextLine();
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

        Car car = new Car(brand, model, fuelType, registrationNumber, registrationYear, odometer, type, isRented);
        // Send car to DB
    }

    public void createRentalAgreement() {
        String name;
        String address;
        int zipCode;
        String city;
        String fromDate;
        String toDate;
        int driverlicenseNumber;
        int maxKm;
        int km;
        int carRegristrationNumber;

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
        driverlicenseNumber = ui.readChoiceInt();
        System.out.print("\nEnter Max Kilometer of Rental Agreement: ");
        maxKm = ui.readChoiceInt();
        System.out.print("\nEnter Kilometer of Vehicle: ");
        km = ui.readChoiceInt();
        System.out.print("\nEnter Car Registration Number: ");
        carRegristrationNumber = ui.readChoiceInt();

        Rental rentalAgreement = new Rental(name,address,zipCode,city,fromDate,toDate,driverlicenseNumber,maxKm,km,carRegristrationNumber);
        // Send agreement to DB and print out?
    }
}