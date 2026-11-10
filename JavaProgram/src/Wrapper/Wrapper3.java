package Wrapper;

public class Wrapper3 {

    public static void main(String[] args) {

        String s1 = "100";
        String s2 = "200";

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);

        int sum = a + b;

        System.out.println("First Number: " + a);
        System.out.println("Second Number: " + b);
        System.out.println("Addition: " + sum);

        String s3 = Integer.toString(sum);

        System.out.println("Converted to String: " + s3);
    }
}
