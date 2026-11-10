package Oops;

import java.util.Scanner;

public class CarRental2 {

    Scanner sc = new Scanner(System.in);

    void calculateRent(int hrs) {
        int amount = hrs * 500;
        System.out.println("Total rent: Rs." + amount);
    }

    void calculateRent(boolean isDaily, int days) {
        if (isDaily) {
            int amount = days * 3000;
            System.out.println("Total rent: Rs." + amount);
        }
    }

    void calculateRent(int days, int amount, boolean isDriver) {
        int total = days * amount;

        if (isDriver) {
            total = total + (days * 1000);
        }

        System.out.println("Total rent: Rs." + total);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CarRental c = new CarRental();

        System.out.println("1. Rent by Hours");
        System.out.println("2. Rent by Days");
        System.out.println("3. Rent by Days with Driver");
        System.out.print("Choose your option: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter hours: ");
                int hrs = sc.nextInt();
                c.calculateRent(hrs);
                break;

            case 2:
                System.out.print("Enter number of days: ");
                int days = sc.nextInt();
                c.calculateRent(true, days);
                break;

            case 3:
                System.out.print("Enter number of days: ");
                int d = sc.nextInt();

                System.out.print("Do you want a driver? (true/false): ");
                boolean driver = sc.nextBoolean();

                c.calculateRent(d, 3000, driver);
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
