package CollectionFramework;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("-------------------");
    }
}

public class ArrayListMenuProgram {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // Add Student
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    list.add(new Student(id, name, marks));

                    System.out.println("Student Added Successfully!");
                    break;

                // View Students
                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No Records Found!");
                    } else {
                        System.out.println("\nStudent Records:");

                        for (Student s : list) {
                            s.display();
                        }
                    }
                    break;

                // Update Student
                case 3:
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();

                    boolean updated = false;

                    for (Student s : list) {
                        if (s.id == updateId) {

                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            s.name = sc.nextLine();

                            System.out.print("Enter New Marks: ");
                            s.marks = sc.nextDouble();

                            updated = true;

                            System.out.println("Record Updated Successfully!");
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Student ID Not Found!");
                    }
                    break;

                // Delete Student
                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (Student s : list) {
                        if (s.id == deleteId) {
                            list.remove(s);

                            deleted = true;

                            System.out.println("Record Deleted Successfully!");
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Student ID Not Found!");
                    }
                    break;

                // Exit
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