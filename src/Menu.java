package src;

import src.entities.Car;

import java.util.Scanner;

public class Menu {
    GenericMenu menu = new GenericMenu("---[Kailau Car Rental]---", "Make your choice: ",new String[] {"1. New Rental Contract", "2. Add New Vehicle", "3. Remove Vehicle"});
    UI ui = new UI();
    Scanner in = new Scanner(System.in);

    public void createNewVehicle() {
        System.out.println("You've selected to Create new Vehicle:");
        String brand;
        String model;
        String fuelType;
        String registrationYear;
        String type;
        String isRentedChoice;
        boolean approvedChoice = false;
        boolean isRented = false;

        System.out.print("Enter Brand of Vehicle: ");
        brand = in.nextLine();
        System.out.print("Enter Model of Vehicle: ");
        model = in.nextLine();
        System.out.print("Enter Fuel Type of Vehicle: ");
        fuelType = in.nextLine();
        System.out.print("Enter Registration Year of Vehicle: ");
        registrationYear = in.nextLine();
        System.out.print("Enter Type of Vehicle: ");
        type = in.nextLine();
        System.out.print("Is Car already rented? (Yes)(No): ");
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

        Car car = new Car(brand, model, fuelType, registrationYear, type, isRented);
    }
}