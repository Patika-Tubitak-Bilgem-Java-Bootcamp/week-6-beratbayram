package core;

import characters.Archer;
import characters.CharacterInfo;
import characters.Knight;
import characters.Samurai;

import locations.*;

import java.util.Objects;
import java.util.Scanner;

public class Game {
    private final Scanner input = new Scanner(System.in);

    public void start() {
        Utils.print("Welcome To Adventure Game");
        System.out.print("Please enter a user name: ");
        String playerName = input.nextLine();

        Player player = new Player(playerName);
        Utils.print("Welcome Mr. " + player.getUsername());

        CharacterInfo[] charList = {new Samurai(), new Archer(), new Knight()};

        Utils.print("===========================================");

        for(CharacterInfo character:charList) {
            Utils.print("Character: " + character.getName() +
                               "\tID: " + character.getId() +
                               "\tDamage: " + character.getDamage() +
                               "\tHealth: " + character.getHealth() +
                               "\tWealth: " + character.getWealth());
        }

        Utils.print("===========================================");

        System.out.print("Enter your character id: ");
        int id = input.nextInt();
        Utils.print("");
        Utils.print("You've become a " + charList[id-1].getName());
        Utils.print("Your skills are here:");
        player.selectChar(id);


        while (true) {
            Utils.print("");
            Utils.print("------------Places-----------------");
            Utils.print("0- Quit Game");
            Utils.print("1- Safe House");
            Utils.print("2- Tool Store");
            Utils.print("3- Forest");
            Utils.print("4- Cave");
            Utils.print("5- River");
            Utils.print("6- Mine");

            System.out.print("Please, select a place: ");
            int locNum = input.nextInt();
            Location loc = null;
            boolean isQuit = false;

            switch (locNum) {
                case 0 -> isQuit = true;
                case 1 -> loc = new SafeHouse(player);
                case 2 -> loc = new ToolStore(player);
                case 3 -> loc = new Forest(player);
                case 4 -> loc = new Cave(player);
                case 5 -> loc = new River(player);
                case 6 -> loc = new Mine(player);
            }

            if (isQuit) {
                Utils.print("You've quited the game. See you soon...");
                break;
            }

            if (!Objects.requireNonNull(loc).onLocation()) {
                Utils.print("GAME OVER");
                break;
            }

            boolean forestCon = player.getInventory().getFirewoodCon();
            boolean caveCon = player.getInventory().getFoodCon();
            boolean riverCon = player.getInventory().getWaterCon();

            if (forestCon && caveCon && riverCon) {
                Utils.print("YOU WIN!!! You've completed the game...");
                break;
            }




        }
    }
}
