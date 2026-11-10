package ExceptionHandling;

public class Exception4 {
    private static String s;

	public static void main(String[] args) {

        try {
            s = null;

            System.out.println(s.length());
        }
        catch (NullPointerException e) {
            System.out.println("Null value cannot be accessed");
        }
    }
}
