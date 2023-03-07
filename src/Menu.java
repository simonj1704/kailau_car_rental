package src;

import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;

    Scanner in = new Scanner(System.in);

    public Menu() {
        setMenuHeader(menuHeader);
        setMenuItems(menuItems);
        setLeadText(leadText);
    }

    private void printMenu() {
        String printString = menuHeader + "\n";
        for (int i = 0; i < menuItems.length; i++)
            printString += menuItems[i] + "\n";
        System.out.print("\n" + printString);
    }

    public int readChoice() {
        int userInput = 0;
        boolean isInt = true;

        do {
            if (in.hasNextInt()) {
                userInput = in.nextInt();
                isInt = false;
            } else {
                System.out.println("Not valid input, please enter a number");
            }

        } while (isInt);
        return userInput;
    }

    private String getMenuHeader() {
        return menuHeader;
    }

    private String getLeadText() {
        return leadText;
    }

    private String[] getMenuItems() {
        return menuItems;
    }

    private void setMenuHeader(String menuHeader) {
        this.menuHeader = menuHeader;
    }

    private void setLeadText(String leadText) {
        this.leadText = leadText;
    }

    private void setMenuItems(String[] menuItems) {
        this.menuItems = menuItems;
    }
}