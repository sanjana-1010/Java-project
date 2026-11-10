package Oops;

class Student {
    private int age;

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    public int getAge() {
        return age;
    }
}

public class Encap {
    public static void main(String[] args) {
        Student s = new Student();

        s.setAge(21);
        System.out.println(s.getAge());
    }
}
