package core;

import java.util.Objects;
import java.util.Scanner;

public class ToolStore extends NormalLoc {
    final Scanner input = new Scanner(System.in);

    public ToolStore(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        Utils.print("");
        Utils.print("*************** Welcome To Tool Store".toUpperCase() + " **********************");
        Utils.print("Welcome Mr. " + this.getPlayer().getUsername() + "... I'm your weapon provider. What would you like to purchase?");
        Utils.print("");
        Utils.print("---------- Weapons ------------");
        Weapon.showWeapons();
        Utils.print("");
        Utils.print("---------- Armors ------------");
        Armor.showArmors();
        Utils.print("");
        Utils.print("Your wealth: " + this.getPlayer().getWealth());
        Utils.print("");
        selectionApi();
        Utils.print("");

        Utils.print("Character: " + this.getPlayer().getName() + "\tWeapon: " + this.getPlayer().getWeaponName() +
                "\tArmor: " + this.getPlayer().getArmorName() + "\tDamage: " + this.getPlayer().getDamage() +
                "\tHealth: " + this.getPlayer().getHealth() + "\tWealth: " + this.getPlayer().getWealth() +
                "\t\tInventory: food-" + (this.getPlayer().getInventory().getFood()) +
                " water-" + (this.getPlayer().getInventory().getWater()) +
                " firewood-" + (this.getPlayer().getInventory().getFirewood()));

        Utils.print("");
        Utils.print("See you soon, Mr. " + this.getPlayer().getUsername() + ". I wish you have a nice day...");

        return true;
    }

    public void selectionApi() {
        Utils.print("You can purchase a weapon or an armor.");
        Utils.print("If you would like to purchase a weapon, please press 1.");
        Utils.print("If you would like to purchase an armor, please press 2.");
        Utils.print("If you would like to leave the tool store, please press 0.");
        System.out.print("Your prefer: ");
        int selectButton = input.nextInt();
        Utils.print("");

        switch (selectButton) {
            case 1:
                buyWeapon();
                selectionApi();
                break;
            case 2:
                buyArmor();
                selectionApi();
                break;
            case 0:

                break;
            default:
                Utils.print("We don't have this kind of an option, Mr. " + this.getPlayer().getUsername() + ". Please, Try Again!");
                Utils.print("");
                selectionApi();
        }
    }

    public void buyWeapon() {
        Utils.print("If you would like to purchase a weapon, please select one of them...");
        Utils.print("If you like to quit, you can press the number 0");
        System.out.print("Your prefer: ");
        int selectWeapon = input.nextInt();
        Utils.print("");
        Weapon weapon = Weapon.selectWeapon(selectWeapon);
        int newDamage, rem;
        String weaponList = this.getPlayer().getWeaponName() + ",";
        Utils.print(weaponList);

        switch (selectWeapon) {
            case 1:
                Utils.print("You've selected a pistol!");
                if (Objects.requireNonNull(weapon).getPrice() > this.getPlayer().getWealth()) {
                    Utils.print("You can not afford to purchase a pistol!!!");
                    buyWeapon();
                } else {
                    Utils.print("You've purchased a pistol.");
                    setWeapon(weapon, weaponList);
                    this.getPlayer().setWeaponName(weapon.getName());
                    buyWeapon();
                }
                break;
            case 2:
                Utils.print("You've selected a sword!");
                if (Objects.requireNonNull(weapon).getPrice() > this.getPlayer().getWealth()) {
                    Utils.print("You can not afford to purchase a sword!!!");
                    buyWeapon();
                } else {
                    Utils.print("You've purchased a sword.");
                    setWeapon(weapon, weaponList);
                    buyWeapon();
                }
                break;
            case 3:
                Utils.print("You've selected a rifle!");
                if (Objects.requireNonNull(weapon).getPrice() > this.getPlayer().getWealth()) {
                    Utils.print("You can not afford to purchase a rifle!!!");
                    buyWeapon();
                } else {
                    Utils.print("You've purchased a rifle.");
                    setWeapon(weapon, weaponList);
                    buyWeapon();
                }
                break;
            case 0:
                break;
            default:
                Utils.print("We don't have this kind of a weapon, Mr. " + this.getPlayer().getUsername() + ". Please, Try Again!");
                Utils.print("");
                buyWeapon();
        }
    }

    private void setWeapon(Weapon weapon, String weaponList) {
        int newDamage;
        int rem;
        this.getPlayer().setWeaponName(weaponList + weapon.getName());
        newDamage = this.getPlayer().getDamage() + weapon.getDamage();
        this.getPlayer().setDamage(newDamage);
        Utils.print("Your Damage: " + this.getPlayer().getDamage());
        rem = this.getPlayer().getWealth() - weapon.getPrice();
        this.getPlayer().setWealth(rem);
        Utils.print("Your remaining  wealth: " + this.getPlayer().getWealth());
    }

    public void buyArmor() {
        Utils.print("If you would like to purchase a armor, please select one of them...");
        Utils.print("If you like to quit, you can press the number 0");
        System.out.print("Your prefer: ");
        int selectArmor = input.nextInt();
        Utils.print("");
        Armor armor = Armor.selectArmor(selectArmor);
        int newHealth, rem;

        switch (selectArmor) {
            case 1:
                Utils.print("You've selected a light armor!");
                if (Objects.requireNonNull(armor).getPrice() > this.getPlayer().getWealth()) {
                    Utils.print("You can not afford to purchase a light armor!!!");
                    buyArmor();
                } else {
                    Utils.print("You've purchased a light armor.");
                    setArmor(armor);
                }
                break;
            case 2:
                Utils.print("You've selected a medium armor!");
                if (Objects.requireNonNull(armor).getPrice() > this.getPlayer().getWealth()) {
                    Utils.print("You can not afford to purchase a sword!!!");
                    buyArmor();
                } else {
                    Utils.print("You've purchased a medium armor.");
                    setArmor(armor);
                }
                break;
            case 3:
                Utils.print("You've selected a heavy armor!");
                if (Objects.requireNonNull(armor).getPrice() > this.getPlayer().getWealth()) {
                    Utils.print("You can not afford to purchase a heavy armor!!!");
                    buyArmor();
                } else {
                    Utils.print("You've purchased a heavy armor.");
                    this.getPlayer().setArmorName(armor.getName());
                    newHealth = this.getPlayer().getWealth() + armor.getShield();
                    setHealth(armor, newHealth);
                }
                break;
            case 0:
                break;
            default:
                Utils.print("We don't have this kind of a armor, Mr. " + this.getPlayer().getUsername() + ". Please, Try Again!");
                Utils.print("");
                buyArmor();
        }
    }

    private void setHealth(Armor armor, int newHealth) {
        int rem;
        this.getPlayer().setHealth(newHealth);
        Utils.print("Your Health: " + this.getPlayer().getHealth());
        rem = this.getPlayer().getWealth() - armor.getPrice();
        this.getPlayer().setWealth(rem);
        Utils.print("Your remaining  wealth: " + this.getPlayer().getWealth());
        buyArmor();
    }

    private void setArmor(Armor armor) {
        int newHealth;
        int rem;
        this.getPlayer().setArmorName(armor.getName());
        newHealth = this.getPlayer().getHealth() + armor.getShield();
        setHealth(armor, newHealth);
    }

}
