package src;

import java.util.Scanner;

public class Menu {

    Scanner input = new Scanner(System.in);

    public void run() {
        while (true) {
            Utils.println("WELCOME :)");

            Utils.println("1) Notebook ");
            Utils.println("2) Mobile Phone");
            Utils.println("3) List Brands");
            Utils.println("0) Exit");

            Utils.println("Your choice: ");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1 -> Product.processMenu(1);
                case 2 -> Product.processMenu(2);
                case 3 -> Brand.printBrands();
                case 0 -> {
                    Utils.println("See U :)");
                    return;
                }
                default -> Utils.println("Invalid option, try again");
            }
        }
    }
}
