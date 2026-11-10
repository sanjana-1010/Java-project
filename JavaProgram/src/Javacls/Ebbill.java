package Javacls;

import java.util.Scanner;

public class Ebbill {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Consumer ID: ");
        int conid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        String conname = sc.nextLine();

        System.out.print("Enter Previous Unit: ");
        int previous = sc.nextInt();

        System.out.print("Enter Current Unit: ");
        int current = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Type of Building (Domestic/Commercial): ");
        String building = sc.nextLine();

        int units = current - previous;
        double rate;
        double bill;

        if (units < 0) {
            System.out.println("Invalid meter readings!");
        } else {
            if (building.equalsIgnoreCase("Domestic")) {
                rate = 3.0;
            } else if (building.equalsIgnoreCase("Commercial")) {
                rate = 7.0;
            } else {
                System.out.println("Invalid building type!");
                sc.close();
                return;
            }

            bill = units * rate;

            System.out.println("\nEB Bill Details");
            System.out.println("Consumer ID: " + conid);
            System.out.println("Consumer Name: " + conname);
            System.out.println("Previous Unit: " + previous);
            System.out.println("Current Unit: " + current);
            System.out.println("Units Consumed: " + units);
            System.out.println("Building Type: " + building);
            System.out.println("Total EB Bill: Rs. " + bill);
        }

        sc.close();

	}

}
