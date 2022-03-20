package account;

import address.AddressManager;
import address.BusinessAddress;
import address.HomeAddress;
import insurance.*;
import login.*;
import utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Account {

    public enum AuthenticationStatus {
        SUCCESS,
        FAIL
    }

    public Scanner input = new Scanner(System.in);

    private final User user;
    AuthenticationStatus authStatus;
    private final ArrayList<Insurance> insuranceList = new ArrayList<>();


    public Account(User user) {
        this.user = user;
    }

    public void accountMenu() {
        
        Utils.print("Account Owner: " + this.getUser().getLastName());
        Utils.print("---------------------------------------");
        Utils.print("1 - Show Account Information");
        Utils.print("2 - Add Addresses");
        Utils.print("3 - Show Addresses");
        Utils.print("4 - Add Insurance");
        Utils.print("5 - Show Insurance");
        Utils.print("6 - Calculate the total cost of your insurance");
        Utils.print("0 - Log out the account");
        Utils.print("Your choice: ");
        int choice = input.nextInt();
        boolean isExit = false;

        switch (choice) {
            case 1:
                this.showUserInfo();
                break;
            case 2:
                this.showAddresses();
                break;
            case 3:
                this.addAddresses();
                break;
            case 4:
                this.addInsurance();
                break;
            case 5:
                this.showInsuranceList();
                break;
            case 6:
                // Calculate total cost
                break;
            case 0:
                Utils.print("Logging out the account...");
                isExit = true;
                break;
            default:
                Utils.print("There is no such an option. Try again.");
                break;
        }

        if (isExit) {
            return;
        }

        this.accountMenu();

    }

    public final void showUserInfo() {
        Utils.print("First Name: " + user.getFirstName());
        Utils.print("Last Name: " + user.getLastName());
        Utils.print("Email: " + user.getEmail());
        Utils.print("Occupation: " + user.getOccupation());
        Utils.print("Age: " + user.getAge());
        Utils.print("Last Log In Date: ");
    }

    public void addAddresses() {
        
        Utils.print("1 - Home Addresses");
        Utils.print("2 - Business Addresses");
        Utils.print("0 - Go Back To Menu");
        Utils.print("Your choice: ");
        int choice = input.nextInt();

        Utils.print("Neighbourhood: ");
        String neighbourhood = input.next();
        Utils.print("Street Name: ");
        String streetName = input.next();
        Utils.print("Building Name: ");
        String buildingName = input.next();
        Utils.print("Floor Name: ");
        int floorNumber = input.nextInt();
        Utils.print("Flat Number: ");
        int flatNumber = input.nextInt();
        Utils.print("Post Code: ");
        String postCode = input.next();
        Utils.print("Town: ");
        String town = input.next();
        Utils.print("District: ");
        String district = input.next();
        Utils.print("Province: ");
        String province = input.next();
        Utils.print("Country: ");
        String country = input.next();

        switch (choice) {
            case 1 -> {
                HomeAddress newHomeAddress = new HomeAddress(neighbourhood, streetName, buildingName, floorNumber,
                        flatNumber, postCode, town, district, province, country);
                AddressManager.addHomeAddress(newHomeAddress);
            }
            case 2 -> {
                BusinessAddress newBusinessAddress = new BusinessAddress(neighbourhood, streetName, buildingName,
                        floorNumber, flatNumber, postCode, town,
                        district, province, country);
                AddressManager.addBusinessAddress(newBusinessAddress);
            }
            case 0 -> Utils.print("Going back to Account Menu...");
            default -> {
                Utils.print("There is no such an option. Please try again.");
                addAddresses();
            }
        }
    }

    public void showAddresses() {
        
        Utils.print("1 - Home Addresses");
        Utils.print("2 - Business Addresses");
        Utils.print("0 - Go Back To Menu");
        Utils.print("Your choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                
                Utils.print("Home Addresses");
                Utils.print("------------------------");
                for (HomeAddress homeAddress : AddressManager.getListHomeAddress()) {
                    Utils.printAddressInfo(homeAddress);
                }
            }
            case 2 -> {
                
                Utils.print("Business Addresses");
                Utils.print("------------------------");
                for (BusinessAddress businessAddress : AddressManager.getListBusinessAddress()) {
                    Utils.printAddressInfo(businessAddress);
                }
            }
            case 0 -> Utils.print("Going back to Account Menu...");
            default -> {
                Utils.print("There is no such an option. Please try again.");
                showAddresses();
            }
        }
    }

    public void logIn(String email, String password) throws InvalidAuthenticationException {
        if (email.equals(this.getUser().getEmail()) && password.equals(user.getPassword())) {
            authStatus = AuthenticationStatus.SUCCESS;
        } else {
            authStatus = AuthenticationStatus.FAIL;
        }

        switch (authStatus) {
            case SUCCESS -> {
                Utils.print("You've succeeded in logging in your account.");
                this.accountMenu();
            }
            case FAIL -> throw new InvalidAuthenticationException("Invalid Authentication");
        }

    }

    public void addInsurance() {
        
        Utils.print("Insurance Types");
        Utils.print("1 - Car Insurance");
        Utils.print("2 - Health Insurance");
        Utils.print("3 - Residence Insurance");
        Utils.print("4 - Travel Insurance");
        Utils.print("0 - Back To Account Menu");
        Utils.print("Your choice: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> insuranceList.add(new CarInsurance());
            case 2 -> insuranceList.add(new HealthInsurance());
            case 3 -> insuranceList.add(new ResidenceInsurance());
            case 4 -> insuranceList.add(new TravelInsurance());
            case 0 -> Utils.print("Going back to Account Menu...");
            default -> {
                Utils.print("There is no such an option. Please try again.");
                addInsurance();
            }
        }
    }



    public void showInsuranceList() {
        
        int count = 1;
        for (Insurance insurance:insuranceList) {
            Utils.print(count++ + " - " + insurance.getClass().getName());
        }
    }

    public User getUser() {
        return user;
    }
}
