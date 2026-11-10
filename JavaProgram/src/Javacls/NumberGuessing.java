package Javacls;

import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 7;
        int guess;
        boolean found = false;

        for (int i = 1; i <= 3; i++) {
            System.out.print("Guess the number (1 to 10): ");
            guess = sc.nextInt();

            if (guess == number) {
                System.out.println("Correct! You won.");
                found = true;
                break;
            } else {
                System.out.println("Wrong guess!");
            }
        }

        if (found == false) {
            System.out.println("You lost! The number was " + number);
        }

        sc.close();
    }
}
