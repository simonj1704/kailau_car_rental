package src;

import java.util.Scanner;

public class GenericMenu {
    private String menuHeader;
    private String leadText;
    private String[] menuItems;

    public GenericMenu(String menuHeader, String leadText, String[] menuItems) {
        setMenuHeader(menuHeader);
        setMenuItems(menuItems);
        setLeadText(leadText);
    }

    public void printMenu() {
        String printString = menuHeader + "\n";
        for (int i = 0; i < menuItems.length; i++)
            printString += menuItems[i] + "\n";
        System.out.print("\n" + printString);
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