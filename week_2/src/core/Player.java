package core;

import characters.Archer;
import characters.CharacterInfo;
import characters.Knight;
import characters.Samurai;

import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);

    private CharacterInfo charMain;
    private String weaponName;
    private String armorName;
    private int damage;
    private int health;
    private int wealth;
    private String charName;
    private String userName;
    private String name;
    private Inventory inventory = new Inventory();

    public Player(String userName) {
        this.userName = userName;
        this.weaponName = "Beat";
        this.armorName = "No Shield";
    }

    public void selectChar(int id) {
        CharacterInfo[] charList = {new Samurai(), new Archer(), new Knight()};

        if (charList.length <= id-1) {
            id = 1;
        }

        CharacterInfo character = charList[id-1];

        initPlayer(character);

        Utils.print("Character: " + this.getName() + "\tWeapon: " + this.getWeaponName() +
                           "\tArmor: " + this.getArmorName() + "\tDamage: " + this.getDamage() +
                           "\tHealth: " + this.getHealth() + "\tWealth: " + this.getWealth() +
                           "\t\tInventory: food-" + (inventory.getFood()) + " water-" + (inventory.getWater()) +
                           " firewood-" + (inventory.getFirewood()) + " Bonus Armor: " + (inventory.getBonusArmor()));

    }

    public void initPlayer(CharacterInfo character) {
        this.setName(character.getName());
        this.setDamage(character.getDamage());
        this.setHealth(character.getHealth());
        this.setWealth(character.getWealth());
    }




    //         GETTERS & SETTERS


    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getWealth() {
        return wealth;
    }
    public void setWealth(int money) {
        this.wealth = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
