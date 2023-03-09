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
    public void printLine(String message){
        System.out.println(message);
    }
    public void print(String message){
        System.out.print(message);
    }

    public String readString(){
        return in.nextLine();
    }

    public String readString(String message){
        print(message);
        return readString();
    }

    public int readInt(){
        int number = in.nextInt();
        in.nextLine(); //scanner bug
        return number;
    }
}
