package account;

import login.Enterprise;
import login.Individual;
import login.InvalidAuthenticationException;
import utils.Utils;

import java.util.TreeSet;

public class AccountManager {

    private static final TreeSet<Individual> accountsIndividual = new TreeSet<>(new AccountComparator());
    private static final TreeSet<Enterprise> accountsEnterprise = new TreeSet<>(new AccountComparator());

    public static void logIn(String email, String password, int choice) {
        if (choice == 1) {
            for (Individual account : accountsIndividual) {
                try {
                    account.logIn(email, password);
                } catch (InvalidAuthenticationException e) {
                    if (email.equals(account.getUser().getEmail()) && !password.equals(account.getUser().getPassword())) {
                        Utils.print("The email exists in the system. However, password is wrong. Please, enter password again.");
                    } else {
                        Utils.print("Such an account does not exist in the system.");
                        Utils.print("If you don't have an account, you can sign up.");
                    }
                }
            }
        } else if (choice == 2){
            for (Enterprise account:accountsEnterprise) {
                try {
                    account.logIn(email, password);
                } catch (InvalidAuthenticationException e) {
                    if (email.equals(account.getUser().getEmail()) && !password.equals(account.getUser().getPassword())) {
                        Utils.print("The email exists in the system. However, password is wrong. Please, enter password again.");
                    } else {
                        Utils.print("Such an account does not exist in the system.");
                        Utils.print("If you don't have an account, you can sign up.");
                    }
                }
            }
        }
        if (accountsIndividual.isEmpty() && accountsEnterprise.isEmpty()) {
            Utils.print("Such an account does not exist in the system.");
            Utils.print("If you don't have an account, you can sign up.");
        }
    }

    public static TreeSet<Individual> getAccountsIndividual() {
        return accountsIndividual;
    }

    public static void addAccountsIndividual(Individual account) {
        accountsIndividual.add(account);
    }

    public static TreeSet<Enterprise> getAccountsEnterprise() {
        return accountsEnterprise;
    }

    public static void addAccountsEnterprise(Enterprise account) {
        accountsEnterprise.add(account);
    }
}
