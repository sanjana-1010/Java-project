package CollectionFramework;

import java.util.*;

class Player {

    String name;
    int score;

    // Constructor
    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Display player details
    public String toString() {
        return "Name: " + name + ", Score: " + score;
    }
}

public class CricketSystem {

    public static void main(String[] args) {

        // Creating HashMap
        // Key = Player ID
        // Value = Player Object

        Map<Integer, Player> players = new HashMap<>();

        // Adding players
        players.put(101, new Player("Dhoni", 90));
        players.put(102, new Player("Kohli", 100));
        players.put(103, new Player("Dhoni", 80));
        players.put(104, new Player("Rohit", 95));
        players.put(105, new Player("Kohli", 110));

        // Display all players
        System.out.println("----- All Player Details -----");

        for (Map.Entry<Integer, Player> entry : players.entrySet()) {

            System.out.println("Player ID: " + entry.getKey());

            System.out.println(entry.getValue());

            System.out.println();
        }

        // Check player existence using ID
        int searchId = 103;

        System.out.println("----- Search By Player ID -----");

        if (players.containsKey(searchId)) {

            System.out.println("Player ID exists!");

            System.out.println("Player Details: "
                    + players.get(searchId));

        } else {

            System.out.println("Player ID does not exist!");
        }

        // Search player by name
        String searchName = "Dhoni";

        System.out.println("\n----- Search By Player Name -----");

        boolean found = false;

        for (Map.Entry<Integer, Player> entry : players.entrySet()) {

            if (entry.getValue().name.equalsIgnoreCase(searchName)) {

                System.out.println("Player Found!");

                System.out.println("Player ID: " + entry.getKey());

                System.out.println("Player Name: "
                        + entry.getValue().name);

                System.out.println("Player Score: "
                        + entry.getValue().score);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Player not found!");
        }
    }
}
