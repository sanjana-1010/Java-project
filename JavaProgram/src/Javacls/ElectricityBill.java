package Javacls;

import java.util.Scanner;

public class ElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0;

        for (int i = 1; i <= 6; i++) {
            System.out.print("Enter units for month " + i + ": ");
            int units = sc.nextInt();

            double bill = units * 5;
            System.out.println("Bill = Rs. " + bill);

            total = total + bill;
        }

        System.out.println("Total bill for 6 months = Rs. " + total);
        sc.close();
    }
}