package src;

import java.util.Scanner;

public class UI {
    Scanner in = new Scanner(System.in);
    public int readChoiceInt() {
        boolean validChoice = false;
        int choice = -1;

        do {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                in.nextLine();
                validChoice = true;
            } else {
                System.out.println("Please choose an option\n");
                in.nextLine();
            }
        } while (!validChoice);
        return choice;
    }

    public String readString() {
        return in.nextLine();
    }

    public static void main(String[] args) {
        UI ui = new UI();
        int iner = ui.readChoiceInt();
        System.out.println(iner);
        String date = ui.readDate();
        System.out.println(date);
    }

    public String readDate() {
        Input_Output op = new Input_Output();
        boolean approvedDate = false, approvedMonth = false, approvedYear = false;
        int day = -1, month = -1, year = -1, choice;
        while (!approvedDate) {
            op.print("Enter day: ");
            choice = readChoiceInt();
            op.print("\n");
            if (choice < 32 && choice > 0) {
                day = choice;
                approvedDate = true;
            } else
                op.printLine("Invalid Input. Please enter a number between 1 and 31.");
        }
        while (!approvedMonth) {
            op.print("Enter month: ");
            choice = readChoiceInt();
            op.print("\n");
            if (choice < 13 && choice > 0) {
                month = choice;
                approvedMonth = true;
            } else
                op.printLine("Invalid Input. Please enter a number between 1 and 12.");
        }
        while (!approvedYear) {
            op.print("Enter year: ");
            choice = readChoiceInt();
            op.print("\n");
            if (choice < 9999 && choice > 1950) {
                year = choice;
                approvedYear = true;
            } else
                op.printLine("Invalid Input.");
        }
        return year + "-" + month + "-" + day;
    }

    public int readInt() {
        int number = in.nextInt();
        in.nextLine(); //scanner bug
        return number;
    }
}
