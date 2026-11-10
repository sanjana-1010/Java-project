package Oops;

import java.util.Scanner;

class Customer {

    String name;
    double distance;

    void getDetails(Scanner sc) {

        System.out.print("Enter Customer Name: ");
        name = sc.nextLine();

        System.out.print("Enter Distance: ");
        distance = sc.nextDouble();
    }
}
