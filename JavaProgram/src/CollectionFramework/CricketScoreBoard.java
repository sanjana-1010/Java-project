package CollectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CricketScoreBoard {

    public static void main(String[] args) {

        HashMap<String, Integer> scoreboard = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        int choice;
        String player;

        do {
            System.out.println("\n===== Cricket Score Board =====");
            System.out.println("1. Add Player");
            System.out.println("2. Update Player Score");
            System.out.println("3. Search Player");
            System.out.println("4. Remove Player");
            System.out.println("5. Display Score Board");
            System.out.println("6. Find Highest Scorer");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Player Name: ");
                    player = sc.nextLine();

                    if (scoreboard.containsKey(player)) {
                        System.out.println("Player already exists.");
                    } else {
                        System.out.print("Enter Runs: ");
                        int runs = sc.nextInt();

                        scoreboard.put(player, runs);

                        System.out.println("Player Added Successfully.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Player Name: ");
                    player = sc.nextLine();

                    if (scoreboard.containsKey(player)) {

                        System.out.print("Enter New Score: ");
                        int runs = sc.nextInt();

                        scoreboard.put(player, runs);

                        System.out.println("Score Updated Successfully.");

                    } else {
                        System.out.println("Player Not Found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Player Name: ");
                    player = sc.nextLine();

                    if (scoreboard.containsKey(player)) {
                        System.out.println(player + " scored "
                                + scoreboard.get(player) + " runs.");
                    } else {
                        System.out.println("Player Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Player Name: ");
                    player = sc.nextLine();

                    if (scoreboard.containsKey(player)) {
                        scoreboard.remove(player);
                        System.out.println("Player Removed Successfully.");
                    } else {
                        System.out.println("Player Not Found.");
                    }
                    break;

                case 5:
                    if (scoreboard.isEmpty()) {
                        System.out.println("Score Board is Empty.");
                    } else {
                        System.out.println("\nPlayer\t\tRuns");
                        System.out.println("----------------------");

                        for (Map.Entry<String, Integer> entry
                                : scoreboard.entrySet()) {

                            System.out.println(entry.getKey()
                                    + "\t\t" + entry.getValue());
                        }
                    }
                    break;

                case 6:
                    if (scoreboard.isEmpty()) {
                        System.out.println("Score Board is Empty.");
                    } else {
                        String topPlayer = "";
                        int highestRuns = Integer.MIN_VALUE;

                        for (Map.Entry<String, Integer> entry
                                : scoreboard.entrySet()) {

                            if (entry.getValue() > highestRuns) {
                                highestRuns = entry.getValue();
                                topPlayer = entry.getKey();
                            }
                        }

                        System.out.println("\nHighest Scorer");
                        System.out.println("Player : " + topPlayer);
                        System.out.println("Runs : " + highestRuns);
                    }
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}
