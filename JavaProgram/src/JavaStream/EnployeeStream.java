package JavaStream;

import java.util.*;

class Employee {

    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class EnployeeStream {
    public static void main(String[] args) {

        List<Employee> empList = Arrays.asList(
            new Employee(1, "Ram", 50000),
            new Employee(2, "John", 30000),
            new Employee(3, "Arun", 70000)
        );

        empList.stream()
               .filter(e -> e.salary > 40000)
               .forEach(e -> System.out.println(e.name));
    }
}
