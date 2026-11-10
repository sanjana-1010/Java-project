package Oops;
class Employeee {
    int employeeId;
    String employeeName;
    double basicSalary;

    Employeee(int employeeId, String employeeName, double basicSalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.basicSalary = basicSalary;
    }

    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

class Manager extends Employeee {

    Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    double calculateSalary() {
        return basicSalary + (basicSalary * 30 / 100)
                + (basicSalary * 10 / 100);
    }

    void display() {
        System.out.println("\n--- Manager Details ---");
        displayDetails();
        System.out.println("Final Salary: " + calculateSalary());
    }
}

class Developer extends Employeee {

    Developer(int id, String name, double salary) {
        super(id, name, salary);
    }

    double calculateSalary() {
        return basicSalary + (basicSalary * 20 / 100)
                + (basicSalary * 5 / 100);
    }

    void display() {
        System.out.println("\n--- Developer Details ---");
        displayDetails();
        System.out.println("Final Salary: " + calculateSalary());
    }
}

class Intern extends Employeee {

    Intern(int id, String name, double salary) {
        super(id, name, salary);
    }

    double calculateSalary() {
        return basicSalary + (basicSalary * 5 / 100);
    }

    void display() {
        System.out.println("\n--- Intern Details ---");
        displayDetails();
        System.out.println("Final Salary: " + calculateSalary());
    }
}

public class Inheritence1 {
    public static void main(String[] args) {

        Manager m = new Manager(101, "Rahul", 50000);
        Developer d = new Developer(102, "Priya", 40000);
        Intern i = new Intern(103, "Amit", 15000);

        m.display();
        d.display();
        i.display();
    }
}

