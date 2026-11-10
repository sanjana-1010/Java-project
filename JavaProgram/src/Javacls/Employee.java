package Javacls;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String empname = sc.nextLine();

        System.out.print("Enter employee ID: ");
        int empid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter department: ");
        String empdept = sc.nextLine();

        System.out.print("Enter designation: ");
        String empdesign = sc.nextLine();

        System.out.print("Enter basic salary: ");
        double basic = sc.nextDouble();

        double hra = basic * 0.20;
        double gpa = basic * 0.10;
        double pf = basic * 0.12;

        double grosspay = basic + hra + gpa;
        double netpay = grosspay - pf;

        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + empname);
        System.out.println("Employee ID: " + empid);
        System.out.println("Department: " + empdept);
        System.out.println("Designation: " + empdesign);
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hra);
        System.out.println("GPA: " + gpa);
        System.out.println("Gross Pay: " + grosspay);
        System.out.println("PF: " + pf);
        System.out.println("Net Pay: " + netpay);

        sc.close();

	}

}
