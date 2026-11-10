package Wrapper;


public class Wrapper2 {

    public static void main(String[] args) {

        int a = 50;

        // Autoboxing
        Integer obj = a;

        System.out.println("Autoboxing: " + obj);

        // Auto-unboxing
        int b = obj;

        System.out.println("Auto-unboxing: " + b);
    }
}