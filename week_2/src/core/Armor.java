package core;

import locations.Obstacle;

import java.util.Objects;
import java.util.Scanner;

public class Armor {
    private String name;
    private int id;
    private int shield;
    private int price;

    public Armor(String name, int id, int shield, int price) {
        this.name = name;
        this.id = id;
        this.shield = shield;
        this.price = price;
    }

    public static void showArmors() {
        Armor[] armorList = new Armor[3];

        armorList[0] = new Armor("Light", 1, 1, 15);    // Pistol
        armorList[1] = new Armor("Medium", 2, 3, 25);     // Sword
        armorList[2] = new Armor("Heavy", 3, 5, 40);     // Rifle

        for (Armor armor : armorList) {
            Utils.print(armor.getName() + "\tID: " + armor.getId() + "\tShield: " + armor.getShield() + "\tPrice" + armor.getPrice());
        }
    }

    public static Armor selectArmor(int id) {
        Armor[] armorList = new Armor[3];

        armorList[0] = new Armor("Light", 1, 1, 15);    // Pistol
        armorList[1] = new Armor("Medium", 2, 3, 25);     // Sword
        armorList[2] = new Armor("Heavy", 3, 5, 40);     // Rifle

        for (Armor armor : armorList) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getShield() {
        return shield;
    }
    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public abstract static class BattleLoc extends Location {
         final Scanner input = new Scanner(System.in);

        private final Obstacle obstacle;
        private String name;

        public BattleLoc(Player player, String name, Obstacle o) {
            super(player);
            this.name = name;
            this.obstacle = o;
        }

        @Override
        public boolean onLocation() {
            switch (this.getName()) {
                case "Forest":
                    if (this.getPlayer().getInventory().getFirewoodCon()) {
                        Utils.print("You've already passed " + this.getName() + ". You can not enter here!!!");
                        return true;
                    }
                    break;
                case "Cave":
                    if (this.getPlayer().getInventory().getFoodCon()) {
                        Utils.print("You've already passed " + this.getName() + ". You can not enter here!!!");
                        return true;
                    }
                    break;
                case "River":
                    if (this.getPlayer().getInventory().getWaterCon()) {
                        Utils.print("You've already passed " + this.getName() + ". You can not enter here!!!");
                        return true;
                    }
                    break;
            }

            Utils.print("You are in " + this.getName());
            Utils.print("Hey, be careful and sure of being well-prepared. Here is " + this.getObstacle().getName() + "'s place!!!");
            if (!whatToDo()) {
                return false;
            }
            Utils.print("");
            Utils.print("You are on the main menu. You can make a choice up to where you would like to enter.");
            return true;
        }

        public boolean whatToDo() {
            Utils.print("Fight or Leave?\n\nPress 1 to fight or Press 0 to leave");
            int whatToDo = input.nextInt();

            switch (whatToDo) {
                case 0 -> Utils.print("You've left the " + this.getName());
                case 1 -> {
                    Utils.print("It is time to attack right now! ATTACK!!!");
                    return combat();
                }
                default -> {
                    Utils.print("Mr. " + this.getPlayer().getUsername() + ", please respecify what you would like to do...");
                    whatToDo();
                }
            }

            return true;
        }

        public boolean combat() {
            int numObstacle = Obstacle.obstacleNumber(this.getObstacle().getId());
            String obstacle = this.getObstacle().getName();
            Utils.print(numObstacle + " " + obstacle + "s are present in the " + this.getName());

            String keyboard;
            int obstacleRemDamage, playerRemDamage;
            int defaultObstacleHealth = this.getObstacle().getHealth();

            if (this.getName().equals("Mine")) {
                int[] snakeDemArr = {3, 4, 5, 6};
                int idx = (int) (Math.random() * 4);
                this.getObstacle().setDamage(snakeDemArr[idx]);
                Utils.print("Snake Damage: " + this.getObstacle().getDamage());
            }

            double probability = Math.random();
            int whichSideStart = probability >= 0.5 ? 1 : 0;

            if (whichSideStart == 1) {
                Utils.print("You're starting the round.");
            } else {
                Utils.print(this.getObstacle().getName() + " is starting the round.");
            }

            boolean exitLoop = false;

            for (int i = 0; i < numObstacle; i++) {
                while (0 < this.getPlayer().getHealth() && 0 < this.getObstacle().getHealth()) {
                    if (whichSideStart == 1) {
                        Utils.print("Press A to attack or Press R to run away.");
                        keyboard = input.next().toUpperCase();

                        if (keyboard.equals("A")) {
                            Utils.print("You've attacked.");
                            obstacleRemDamage = this.getObstacle().getHealth() - this.getPlayer().getDamage();
                            this.getObstacle().setHealth(obstacleRemDamage);
                        }

                        Utils.print("If you want to run away, Press R.");
                        keyboard = input.next().toUpperCase();
                        if (keyboard.equals("R")) {
                            exitLoop = true;
                            break;
                        }

                        if (0 < this.getObstacle().getHealth()) {
                            Utils.print(this.getObstacle().getName() + " has attacked you. It's your turn now.");
                            playerRemDamage = this.getPlayer().getHealth() - this.getObstacle().getDamage();
                            this.getPlayer().setHealth(playerRemDamage);
                        }

                    } else {
                        if (0 < this.getPlayer().getHealth()) {
                            playerRemDamage = this.getPlayer().getHealth() - this.getObstacle().getDamage();
                            this.getPlayer().setHealth(playerRemDamage);
                            Utils.print(this.getObstacle().getName() + " has attacked you. It's your turn now.");

                            Utils.print("Press A to attack or Press R to run away.");
                            keyboard = input.next().toUpperCase();
                            if (keyboard.equals("A")) {
                                obstacleRemDamage = this.getObstacle().getHealth() - this.getPlayer().getDamage();
                                this.getObstacle().setHealth(obstacleRemDamage);
                            }
                            if (keyboard.equals("R")) {
                                exitLoop = true;
                                break;
                            }

                        }
                    }

                    if (this.getObstacle().getHealth() <= 0) {
                        Utils.print("Your Health: " + this.getPlayer().getHealth() + " " + this.getObstacle().getName() + "'s Health: 0");
                    } else {
                        if (this.getPlayer().getHealth() <= 0) {
                            Utils.print("Your Health: 0 " + this.getObstacle().getName() + "'s Health: " + this.getObstacle().getHealth());
                        } else {
                            Utils.print("Your Health: " + this.getPlayer().getHealth() + " " + this.getObstacle().getName() + "'s Health: " + this.getObstacle().getHealth());
                        }
                    }
                }

                if (exitLoop) break;

                if (this.getObstacle().getHealth() <= 0) {
                    Utils.print("You've killed " + (i + 1) + ". " + this.getObstacle().getName());
                    setWealthLoc();
                    Utils.print("Your Health: " + this.getPlayer().getHealth() + " Your Wealth: " + this.getPlayer().getWealth());
                    Utils.print("");
                    this.getObstacle().setHealth(defaultObstacleHealth);
                }
            }

            if (exitLoop) {
                return true;
            }

            if (this.getPlayer().getHealth() <= 0) {
                Utils.print("You've died...");
                return false;
            }

            Utils.print("You've killed all " + this.getObstacle().getName() + "s");

            switch (this.getName()) {
                case "Forest" -> {
                    this.getPlayer().getInventory().setFirewoodCon(true);
                    this.getPlayer().getInventory().setFirewood("Firewood(acquired)");
                }
                case "Cave" -> {
                    this.getPlayer().getInventory().setFoodCon(true);
                    this.getPlayer().getInventory().setFood("Food(acquired)");
                }
                case "River" -> {
                    this.getPlayer().getInventory().setWaterCon(true);
                    this.getPlayer().getInventory().setWater("Water(acquired)");
                }
            }

            Utils.print("Character: " + this.getPlayer().getName() + "\tWeapon: " + this.getPlayer().getWeaponName() +
                    "\tArmor: " + this.getPlayer().getArmorName() + "\tDamage: " + this.getPlayer().getDamage() +
                    "\tHealth: " + this.getPlayer().getHealth() + "\tWealth: " + this.getPlayer().getWealth() +
                    "\t\tInventory: food-" + (this.getPlayer().getInventory().getFood()) +
                    " water-" + (this.getPlayer().getInventory().getWater()) + " firewood-" +
                    (this.getPlayer().getInventory().getFirewood()) +
                    "Bonus Armor: " + (this.getPlayer().getInventory().getBonusArmor()));


            return true;
        }

        public void setWealthLoc() {
            if (this.getObstacle().getId() == 4) {                                                       // ID: 4
                double chanceMajor = Math.random();
                if (chanceMajor < 0.15) {                                                         // chance of WEAPON
                    Utils.print("You've got a chance to get a weapon.");
                    double chanceMinor = Math.random();

                    String weaponList = this.getPlayer().getWeaponName() + ",";

                    if (chanceMinor < 0.2) {
                        Utils.print("You've got a chance to get a rifle.");
                        this.getPlayer().setWeaponName(weaponList + "Rifle");
                        int totalDamage = this.getPlayer().getDamage() + Objects.requireNonNull(Weapon.selectWeapon(3)).getDamage();
                        this.getPlayer().setDamage(totalDamage);

                    } else if (chanceMinor < 0.5) {
                        Utils.print("You've got a chance to get a sword.");
                        this.getPlayer().setWeaponName(weaponList + "Sword");
                        int totalDamage = this.getPlayer().getDamage() + Objects.requireNonNull(Weapon.selectWeapon(2)).getDamage();
                        this.getPlayer().setDamage(totalDamage);

                    } else {
                        Utils.print("You've got a chance to get a pistol.");
                        this.getPlayer().setWeaponName(weaponList + "Pistol");
                        int totalDamage = this.getPlayer().getDamage() + Objects.requireNonNull(Weapon.selectWeapon(1)).getDamage();
                        this.getPlayer().setDamage(totalDamage);
                    }

                } else if (chanceMajor < 0.30) {                                                // chance of ARMOR
                    Utils.print("You've got a chance to get an armor.");
                    double chanceMinor = Math.random();

                    if (chanceMinor < 0.2) {
                        Utils.print("You've got a chance to get a light armor.");
                        this.getPlayer().setArmorName("Light");
                        int totalHealth = this.getPlayer().getHealth() + Objects.requireNonNull(selectArmor(1)).getShield();
                        this.getPlayer().setHealth(totalHealth);
                        this.getPlayer().getInventory().setBonusArmor("Acquired (Light)");
                        this.getPlayer().getInventory().setBonusArmorCon(true);

                    } else if (chanceMinor < 0.5) {
                        Utils.print("You've got a chance to get a medium armor.");
                        this.getPlayer().setArmorName("Medium");
                        int totalHealth = this.getPlayer().getHealth() + Objects.requireNonNull(selectArmor(2)).getShield();
                        this.getPlayer().setHealth(totalHealth);
                        this.getPlayer().getInventory().setBonusArmor("Acquired (Medium)");
                        this.getPlayer().getInventory().setBonusArmorCon(true);

                    } else {
                        Utils.print("You've got a chance to get a heavy armor.");
                        this.getPlayer().setArmorName("Heavy");
                        int totalHealth = this.getPlayer().getHealth() + Objects.requireNonNull(selectArmor(3)).getShield();
                        this.getPlayer().setHealth(totalHealth);
                        this.getPlayer().getInventory().setBonusArmor("Acquired (Heavy)");
                        this.getPlayer().getInventory().setBonusArmorCon(true);
                    }

                } else if (chanceMajor < 0.55) {                                              // chance of AWARD
                    Utils.print("You've got a chance to get an award.");
                    double chanceMinor = Math.random();
                    if (chanceMinor < 0.2) {
                        Utils.print("You've got a chance to get an award 10.");
                        int totalWealth = this.getPlayer().getWealth() + 10;
                        this.getPlayer().setWealth(totalWealth);

                    } else if (chanceMinor < 0.5) {
                        Utils.print("You've got a chance to get an award 5.");
                        int totalWealth = this.getPlayer().getWealth() + 5;
                        this.getPlayer().setWealth(totalWealth);

                    } else {
                        Utils.print("You've got a chance to get an award 1.");
                        int totalWealth = this.getPlayer().getWealth() + 1;
                        this.getPlayer().setWealth(totalWealth);
                    }

                } else {                                                                        // chance of NOTHING
                    Utils.print("Nothing has come out");
                }

            } else {                                                                                         // ID: 1 2 3
                int finalWealth = this.getPlayer().getWealth() + this.getObstacle().getAward();
                this.getPlayer().setWealth(finalWealth);
            }
        }

        public Obstacle getObstacle() {
            return obstacle;
        }
        @Override
        public String getName() {
            return name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

    }
}
