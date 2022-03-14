package locations;

import characters.Archer;
import characters.Knight;
import characters.Samurai;
import core.Armor;
import characters.CharacterInfo;
import core.NormalLoc;
import core.Player;
import core.Utils;

import java.util.Objects;
import java.util.Scanner;

public class SafeHouse extends NormalLoc {
    Scanner input = new Scanner(System.in);

    public SafeHouse(Player player) {
        super(player);
    }

    @Override
    public boolean onLocation() {
        Utils.print("Welcome To Safe House");
        boolean forestCon = this.getPlayer().getInventory().getFirewoodCon();
        boolean caveCon = this.getPlayer().getInventory().getFoodCon();
        boolean riverCon = this.getPlayer().getInventory().getWaterCon();

        if (forestCon && caveCon && riverCon) {
            return true;
        }

        Utils.print("You are in safe.");

        CharacterInfo[] characters = {new Samurai(), new Archer(), new Knight()};
        int defaultPlayerHealth = 0;

        for (CharacterInfo character : characters) {
            if (character.getName().equals(this.getPlayer().getName())) {
                defaultPlayerHealth = character.getHealth();
                break;
            }
        }
        Armor[] armorList = new Armor[3];

        armorList[0] = new Armor("Light", 1, 1, 15);    // Pistol
        armorList[1] = new Armor("Medium", 2, 3, 25);     // Sword
        armorList[2] = new Armor("Heavy", 3, 5, 40);     // Rifle

        if (this.getPlayer().getHealth() < defaultPlayerHealth) {
            this.getPlayer().setHealth(defaultPlayerHealth);

            if (this.getPlayer().getInventory().getBonusArmorCon()) {
                String playerArmorName = this.getPlayer().getArmorName();
                for (Armor armor : armorList) {
                    if (armor.getName().equals(playerArmorName)) {
                        int totalHealth = defaultPlayerHealth + Objects.requireNonNull(Armor.selectArmor(armor.getId())).getShield();
                        this.getPlayer().setHealth(totalHealth);
                        break;
                    }
                }
                this.getPlayer().setArmorName(this.getPlayer().getArmorName());
            } else {
                this.getPlayer().setArmorName("No Shield");
            }
            Utils.print("Your health is fulled!!!");
            Utils.print("Your health is now " + this.getPlayer().getHealth());
        } else {
            Utils.print("Your health has already been fulled!!!");
        }
        Utils.print("You're leaving the safe house, Mr. " + this.getPlayer().getUsername());

        return true;
    }


}
