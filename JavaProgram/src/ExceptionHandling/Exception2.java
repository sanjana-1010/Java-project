package ExceptionHandling;

public class Exception2 {
    public static void main(String[] args) {

        try {
            int arr[] = {10, 20, 30, 40};

            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of range");
        }
    }
}
