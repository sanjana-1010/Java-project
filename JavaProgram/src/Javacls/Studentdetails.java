package Javacls;

import java.util.Scanner;

public class Studentdetails {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter class: ");
        String studentClass = sc.nextLine();

        System.out.print("Enter marks in Subject 1: ");
        int m1 = sc.nextInt();

        System.out.print("Enter marks in Subject 2: ");
        int m2 = sc.nextInt();

        System.out.print("Enter marks in Subject 3: ");
        int m3 = sc.nextInt();

        int total = m1 + m2 + m3;
        double average = total / 3.0;

        System.out.println("\nStudent Details");
        System.out.println("Name: " + name);
        System.out.println("Class: " + studentClass);
        System.out.println("Subject 1 Marks: " + m1);
        System.out.println("Subject 2 Marks: " + m2);
        System.out.println("Subject 3 Marks: " + m3);
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);

        sc.close();

	}

}
