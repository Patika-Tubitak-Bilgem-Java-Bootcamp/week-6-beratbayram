package src;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void print(String str) {
        System.out.println(str);
    }

    public static void play() {
        Scanner input = new Scanner(System.in);

        print("Enter number of teams: ");
        int teamCount = input.nextInt();

        List<String> teams = new ArrayList<>();

        // Getting teams from user
        for (int i = 0; i < teamCount; i++) {
            print("Enter the team count:");
            String team = input.next();
            teams.add(team);
        }

        if (teamCount % 2 != 0) {
            teams.add("X");
            teamCount += 1;
        }

        List<String> tempTeams = new ArrayList<>();

        while (0 < teams.size()) {
            int index = (int) (Math.random() * teams.size());
            tempTeams.add(teams.get(index));
            teams.remove(teams.get(index));
        }

        teams = tempTeams;
        int totalRound = teamCount - 1;
        int numMatchPerRound = teamCount / 2;

        LinkedHashMap<String, ArrayList<ArrayList<String>>> rounds = new LinkedHashMap<>();

        for (int i = 0; i < totalRound; i++) {
            String round = String.valueOf(i + 1);
            rounds.put(round, new ArrayList<>());
        }

        // Filling guest and home lists
        for (int i = 0; i < totalRound; i++) {
            ArrayList<String> homeTeams = new ArrayList<>();
            ArrayList<String> guestTeams = new ArrayList<>();

            for (int j = 0; j < numMatchPerRound; j++) {
                homeTeams.add(teams.get(j));
                guestTeams.add(teams.get((teamCount - 1) - j));
            }

            String round = String.valueOf(i + 1);
            rounds.get(round).add(homeTeams);
            rounds.get(round).add(guestTeams);

            List<String> newTeams = new ArrayList<>();

            newTeams.add(teams.get(0));
            newTeams.add(teams.get((teamCount - 1)));

            for (int k = 1; k < teams.size() - 1; k++)
                newTeams.add(teams.get(k));
            teams = newTeams;
        }

        print("----------------------------------------");

        // Printing the results accordingly
        for (int i = 0; i < 2 * totalRound; i++) {
            print("Round " + (i + 1) + ":");
            for (int j = 0; j < numMatchPerRound; j++) {
                String firstTeam;
                String secondTeam;
                if (i < totalRound) {
                    ArrayList<ArrayList<String>> round = rounds.get(String.valueOf(i + 1));
                    firstTeam = round.get(0).get(j);
                    secondTeam = round.get(1).get(j);
                } else {
                    ArrayList<ArrayList<String>> round = rounds.get(String.valueOf(i + 1 - totalRound));
                    firstTeam = round.get(1).get(j);
                    secondTeam = round.get(0).get(j);
                }
                print("    " + firstTeam + " / " + secondTeam);
            }
        }
    }
}
