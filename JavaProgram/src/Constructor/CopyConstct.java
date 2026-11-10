package Constructor;

class Student1 {
    int id;
    String name;

    // Parameterized constructor
    Student1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Copy constructor
    Student1(Student1 s) {
        this.id = s.id;
        this.name = s.name;
    }

    void display() {
        System.out.println(id + " " + name);
    }
}

public class CopyConstct {
    public static void main(String[] args) {
        Student1 s1 = new Student1(101, "Rahul");

        Student1 s2 = new Student1(s1);

        s1.display();
        s2.display();
    }
}
