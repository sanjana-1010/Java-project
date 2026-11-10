package ExceptionHandling;

import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 5000;

        try {
            System.out.println("----- BANKING SYSTEM -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");

            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("Available Balance: " + balance);
                break;

            case 2:
                System.out.println("Enter deposit amount:");
                double deposit = sc.nextDouble();

                if (deposit <= 0) {
                    throw new IllegalArgumentException(
                        "Deposit amount must be greater than zero");
                }

                balance = balance + deposit;

                System.out.println("Amount deposited successfully");
                System.out.println("Available Balance: " + balance);
                break;

            case 3:
                System.out.println("Enter withdrawal amount:");
                double withdraw = sc.nextDouble();

                if (withdraw <= 0) {
                    throw new IllegalArgumentException(
                        "Withdrawal amount must be greater than zero");
                }

                if (withdraw > balance) {
                    throw new ArithmeticException(
                        "Insufficient Balance");
                }

                balance = balance - withdraw;

                System.out.println("Withdrawal successful");
                System.out.println("Available Balance: " + balance);
                break;

            default:
                System.out.println("Invalid choice");
            }
        }

        catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        catch (java.util.InputMismatchException e) {
            System.out.println("Please enter valid input");
        }

        finally {
            System.out.println("Thank you for using our banking system");
            sc.close();
        }
    }
}
