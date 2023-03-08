package src;

public class Controller {
    Menu menu = new Menu("---[Foods]---", "Make your choice: ",new String[] {"1. Add customer", "2. Banana", "3. Strawberry"});
    UI ui = new UI();
    public static void main(String[] args) {
        new Controller().run();
    }

    public void run() {
        DBHandler dbHandler = new DBHandler();
        dbHandler.addCustomer();
        /*int choice;
        menu.printMenu();
        choice = ui.readChoiceInt();

        switch (choice) {
            case 1 -> System.out.println("You selected Apple");
            case 2 -> System.out.println("You selected Banana ");
            case 3 -> System.out.println("You selected Strawberry");
        }*/
    }


}

