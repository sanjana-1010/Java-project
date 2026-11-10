package StringOperations;

import java.util.Scanner;

public class Strinbuf {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String s = sc.nextLine();

        StringBuffer sb = new StringBuffer(s);

        System.out.println("Original: " + sb);

        sb.append(" Java");
        System.out.println("After append: " + sb);

        sb.delete(0, 2);
        System.out.println("After delete: " + sb);

        sb.replace(0, 3, "Hi");
        System.out.println("After replace: " + sb);

        System.out.println("Length: " + sb.length());

        sc.close();

	}

}
