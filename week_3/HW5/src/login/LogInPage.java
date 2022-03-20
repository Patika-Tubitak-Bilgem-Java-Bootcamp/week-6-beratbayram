package login;

import account.AccountManager;
import utils.Utils;

import java.util.Scanner;

public class LogInPage {
    Scanner input = new Scanner(System.in);

    public void run() {
        while (true) {

            Utils.print("========Insurance Management System========");
            Utils.print("1)Log In");
            Utils.print("2)Sign Up");
            Utils.print("0)Exit");
            Utils.print("Type your choice:");
            int choice = input.nextInt();
            int choiceAccount;
            String emailInput;
            String passwordInput;
            boolean isExit = false;

            switch (choice) {
                case 1 -> {

                    Utils.print("Log In Your Account");
                    Utils.print("========================");
                    Utils.print("1)Individual Account");
                    Utils.print("2)Enterprise Account");
                    Utils.print("0)Go Back To Main Menu");
                    Utils.print("Your choice: ");
                    choiceAccount = input.nextInt();
                    switch (choiceAccount) {
                        case 1 -> {

                            Utils.print("======Individual Account======");
                            Utils.print("Email: ");
                            emailInput = input.next();
                            Utils.print("Password: ");
                            passwordInput = input.next();
                            AccountManager.logIn(emailInput, passwordInput, choiceAccount);
                        }
                        case 2 -> {

                            Utils.print("======Enterprise Account======");
                            Utils.print("Email: ");
                            emailInput = input.next();
                            Utils.print("Password: ");
                            passwordInput = input.next();
                            AccountManager.logIn(emailInput, passwordInput, choiceAccount);
                        }
                        case 0 -> Utils.print("Leaving Menu...");
                    }
                }
                case 2 -> {

                    Utils.print("Sign Up Your Account");
                    Utils.print("========================");
                    Utils.print("1)Individual Account");
                    Utils.print("2)Enterprise Account");
                    Utils.print("0)Go Back To Main Menu");
                    Utils.print("Your choice: ");
                    choiceAccount = input.nextInt();
                    switch (choiceAccount) {
                        case 1 -> {

                            Utils.print("======Individual Account======");
                            Individual accountIndividual = new Individual(new User());
                            accountIndividual.signUp();
                        }
                        case 2 -> {

                            Utils.print("======Enterprise Account======");
                            Enterprise accountEnterprise = new Enterprise(new User());
                            accountEnterprise.signUp();
                        }
                        case 0 -> Utils.print("");
                    }
                }
                case 0 -> isExit = true;
                default -> Utils.print("Invalid Entry");
            }

            if (isExit) {
                Utils.print("Goodbye :)");
                break;
            }
        }
    }
}
