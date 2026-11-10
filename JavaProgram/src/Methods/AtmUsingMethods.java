package Methods;

import java.util.Scanner;

public class AtmUsingMethods {
    static double balance = 10000;

    // Method to check balance
    static void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    // Method to deposit money
    static void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully");
            System.out.println("Balance: Rs." + balance);
        } else {
            System.out.println("Invalid amount");
        }
    }

    // Method to withdraw money
    static void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawal successful");
            System.out.println("Balance: Rs." + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    // Method to transfer money
    static void transfer(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Fund transferred successfully");
            System.out.println("Balance: Rs." + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Fund Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = sc.nextDouble();
                    transfer(transferAmount);
                    break;

                case 5:
                    System.out.println("Thank you for using ATM");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
