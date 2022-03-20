package login;

import account.Account;
import account.AccountManager;
import utils.Utils;

public class Individual extends Account {

    private User user;

    public Individual(User user) {
        super(user);
    }

    public void signUp() {
        Utils.print("    CREATE A NEW ACCOUNT    ");
        Utils.print("============================");
        Utils.print("First Name: ");
        this.getUser().setFirstName(input.next());
        Utils.print("Last Name: ");
        this.getUser().setLastName(input.next());
        Utils.print("Email: ");
        String email = input.next();
        this.getUser().setEmail(email);
        Utils.print("Password: ");
        String password = input.next();
        this.getUser().setPassword(password);
        Utils.print("Occupation: ");
        String occupation = input.next();
        this.getUser().setOccupation(occupation);
        Utils.print("Age: ");
        int age = input.nextInt();
        this.getUser().setAge(age);

        for (Account account : AccountManager.getAccountsIndividual()) {
            if (email.equals(account.getUser().getEmail())) {
                Utils.print("Such an account exists in the system. Be sure of creating a new account.");
                return;
            }
        }
        AccountManager.addAccountsIndividual(this);
        Utils.print("You've signed up the system.");
    }

    public double calculate() {
        return 0;
    }
}
