package Oops;

import java.util.Scanner;

class MiniCab extends Customer implements CabBooking {

 public void bookRide() {
     System.out.println("Mini Cab Booked Successfully!");
 }

 public double calculateFare(double distance) {
     return distance * 10;
 }
}

class AutoCab extends Customer implements CabBooking {

 public void bookRide() {
     System.out.println("Auto Cab Booked Successfully!");
 }

 public double calculateFare(double distance) {
     return distance * 8;
 }
}

class SedanCab extends Customer implements CabBooking {

 public void bookRide() {
     System.out.println("Sedan Cab Booked Successfully!");
 }

 public double calculateFare(double distance) {
     return distance * 15;
 }
}

public class CarBookingInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== CAB BOOKING SYSTEM =====");
        System.out.println("1. Mini Cab");
        System.out.println("2. Auto Cab");
        System.out.println("3. Sedan Cab");

        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        Customer c;
        CabBooking b;

        if (choice == 1) {

            MiniCab m = new MiniCab();
            c = m;
            b = m;

        } else if (choice == 2) {

            AutoCab a = new AutoCab();
            c = a;
            b = a;

        } else if (choice == 3) {

            SedanCab s = new SedanCab();
            c = s;
            b = s;

        } else {

            System.out.println("Invalid Choice!");
            sc.close();
            return;
        }

        c.getDetails(sc);

        b.bookRide();

        System.out.println("Customer Name: " + c.name);
        System.out.println("Distance: " + c.distance + " KM");

        System.out.println("Total Fare: Rs. "+ b.calculateFare(c.distance));

        sc.close();
    }
}


