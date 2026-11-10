package Wrapper;

public class Wrapper1 {

    public static void main(String[] args) {

        int a = 100;

        // Boxing
        Integer obj = Integer.valueOf(a);

        System.out.println("Boxing: " + obj);

        // Unboxing
        int b = obj.intValue();

        System.out.println("Unboxing: " + b);
    }
}
