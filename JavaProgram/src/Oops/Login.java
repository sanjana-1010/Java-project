package Oops;

import java.util.Scanner;

public class Login {

    void login(String username, String password) {
        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Login successful using Username!");
        } else {
            System.out.println("Invalid Username or Password");
        }
    }

    void login(int id, String password) {
        if (id == 101 && password.equals("abcd")) {
            System.out.println("Login successful using ID!");
        } else {
            System.out.println("Invalid ID or Password");
        }
    }

    void login(long mobile, String password) {
        if (mobile == 9876543210L && password.equals("pass123")) {
            System.out.println("Login successful using Mobile Number!");
        } else {
            System.out.println("Invalid Mobile Number or Password");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Login l = new Login();

        System.out.println("----- LOGIN SYSTEM -----");
        System.out.println("1. Login using Username");
        System.out.println("2. Login using ID");
        System.out.println("3. Login using Mobile Number");

        System.out.print("Choose your option: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Enter Username: ");
                String username = sc.nextLine();

                System.out.print("Enter Password: ");
                String password1 = sc.nextLine();

                l.login(username, password1);
                break;

            case 2:
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Password: ");
                String password2 = sc.nextLine();

                l.login(id, password2);
                break;

            case 3:
                System.out.print("Enter Mobile Number: ");
                long mobile = sc.nextLong();
                sc.nextLine();

                System.out.print("Enter Password: ");
                String password3 = sc.nextLine();

                l.login(mobile, password3);
                break;

            default:
                System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
