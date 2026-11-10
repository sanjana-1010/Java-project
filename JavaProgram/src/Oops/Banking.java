package Oops;

import java.util.Scanner;

public class Banking {

    void deposit(double amount) {
        System.out.println("Deposit Amount: Rs." + amount);
    }

    void deposit(double amount, int chequeNo) {
        System.out.println("Deposit Amount: Rs." + amount);
        System.out.println("Cheque Number: " + chequeNo);
    }

    void deposit(double amount, String upiId, String bankName) {
        System.out.println("Deposit Amount: Rs." + amount);
        System.out.println("UPI ID: " + upiId);
        System.out.println("Bank Name: " + bankName);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banking b = new Banking();

        System.out.println("----- BANKING SYSTEM -----");
        System.out.println("1. Deposit using Amount");
        System.out.println("2. Deposit using Cheque");
        System.out.println("3. Deposit using UPI");
        System.out.print("Choose your option: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter amount: ");
                double amount1 = sc.nextDouble();

                b.deposit(amount1);
                break;

            case 2:
                System.out.print("Enter amount: ");
                double amount2 = sc.nextDouble();

                System.out.print("Enter cheque number: ");
                int chequeNo = sc.nextInt();

                b.deposit(amount2, chequeNo);
                break;

            case 3:
                System.out.print("Enter amount: ");
                double amount3 = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter UPI ID: ");
                String upiId = sc.nextLine();

                System.out.print("Enter bank name: ");
                String bankName = sc.nextLine();

                b.deposit(amount3, upiId, bankName);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
