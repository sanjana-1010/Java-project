package CollectionFramework;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
        System.out.println("----------------------");
    }
}

public class EmployeeManagementProgram {

    public static void main(String[] args) {

        ArrayList<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Employee Salary: ");
                    double salary = sc.nextDouble();

                    list.add(new Employee(id, name, salary));

                    System.out.println("Employee Added Successfully!");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No Employee Records Found!");
                    } else {
                        for (Employee e : list) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Employee e : list) {
                        if (e.id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            e.name = sc.nextLine();

                            System.out.print("Enter New Salary: ");
                            e.salary = sc.nextDouble();

                            updated = true;

                            System.out.println("Employee Updated Successfully!");
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Employee ID Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (Employee e : list) {
                        if (e.id == deleteId) {

                            list.remove(e);

                            deleted = true;

                            System.out.println("Employee Deleted Successfully!");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Employee ID Not Found!");
                    }
                    break;

                case 5:
                    System.out.println("Program Exited.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
