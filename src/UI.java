package src;

import java.util.Scanner;

public class UI {
    Scanner in = new Scanner(System.in);
    public int readChoiceInt() {
        boolean validChoice = true;
        int choice = -1;

        do {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                in.nextLine();
                validChoice = true;
            } else {
                System.out.print("Please choose an option\n");
                in.nextLine();
            }
        } while (!validChoice);
        return choice;
    }

    public String readChoiceString(){
        String choice;
        do {
            choice = in.nextLine();
        } while(choice.isEmpty());
        return choice;
    }
}
