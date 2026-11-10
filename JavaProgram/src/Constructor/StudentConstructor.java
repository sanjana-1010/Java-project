package Constructor;

class Student {

    int id;
    String name;
    double marks;

    Student() {
        id = 101;
        name = "Sanjana";
        marks = 85.5;
    }

    void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Student Marks: " + marks);
    }
}

public class StudentConstructor {

    public static void main(String[] args) {

        Student s = new Student();

        s.display();
    }
}
