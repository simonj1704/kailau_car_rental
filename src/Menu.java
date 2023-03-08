package src;

import java.util.Scanner;

public class Menu {
    GenericMenu menu = new GenericMenu("---[Kailau Car Rental]---", "Make your choice: ",new String[] {"1. New Rental Contract", "2. Add New Vehicle", "3. Remove Vehicle"});
    UI ui = new UI();

    public void run() {
        int choice;
        menu.printMenu();
        choice = ui.readChoiceInt();

        switch (choice) {
            case 1 -> System.out.println("You selected Apple");
            case 2 -> System.out.println("You selected Banana ");
            case 3 -> System.out.println("You selected Strawberry");
        }
    }
}