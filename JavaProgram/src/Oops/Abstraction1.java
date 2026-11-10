package Oops;

abstract class Bank {

    abstract void deposit();

    abstract void withdraw();

    void display() {
        System.out.println("Welcome to Banking System");
    }
}

class SBI extends Bank {

    void deposit() {
        System.out.println("Amount deposited successfully");
    }

    void withdraw() {
        System.out.println("Amount withdrawn successfully");
    }
}

public class Abstraction1 {

    public static void main(String[] args) {

        SBI s = new SBI();

        s.display();
        s.deposit();
        s.withdraw();
    }
}
