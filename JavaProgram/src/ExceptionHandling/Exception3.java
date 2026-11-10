package ExceptionHandling;

public class Exception3 {
    public static void main(String[] args) {

        try {
            String s = "Hello";

            int num = Integer.parseInt(s);

            System.out.println(num);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
    }
}
