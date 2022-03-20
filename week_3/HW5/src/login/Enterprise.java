package login;

import account.Account;
import account.AccountManager;
import utils.Utils;

public class Enterprise extends Account {

    private User user;

    public Enterprise(User user) {
        super(user);
    }

    public void signUp() {
        Utils.print("NEW ACCOUNT");
        Utils.print("============================");
        Utils.print("Name:");
        this.user.setFirstName(input.next());
        Utils.print("Surname:");
        this.user.setLastName(input.next());
        Utils.print("Email: ");
        String email = input.next();
        this.user.setEmail(email);
        Utils.print("Password: ");
        String password = input.next();
        this.user.setPassword(password);
        Utils.print("Occupation: ");
        String occupation = input.next();
        this.getUser().setOccupation(occupation);
        Utils.print("Age: ");
        int age = input.nextInt();
        this.getUser().setAge(age);

        for (Account account : AccountManager.getAccountsEnterprise()) {
            if (email.equals(account.getUser().getEmail())) {
                Utils.print("Such an account exists in the system. Be sure of creating a new account.");
                return;
            }
        }

        AccountManager.addAccountsEnterprise(this);
        Utils.print("Signed-up successfully");
    }

}
