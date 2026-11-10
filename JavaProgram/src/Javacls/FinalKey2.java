package Javacls;

class Bank {

    final void interestRate() {
        System.out.println("Bank Interest Rate: 7%");
    }
}

class SBI extends Bank {

    void display() {
        System.out.println("Welcome to SBI Bank");
    }
}

public class FinalKey2 {
    public static void main(String[] args) {

        SBI s = new SBI();

        s.interestRate();
        s.display();
    }
}