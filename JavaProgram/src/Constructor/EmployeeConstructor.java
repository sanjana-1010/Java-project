package Constructor;

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
    }
}

public class EmployeeConstructor {

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Rahul", 30000);
        Employee e2 = new Employee(102, "Priya", 40000);

        e1.display();

        System.out.println("----------------");

        e2.display();
    }
}