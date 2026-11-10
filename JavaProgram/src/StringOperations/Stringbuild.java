package StringOperations;

import java.util.Scanner;

public class Stringbuild {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder(s);

        sb.append(" Java");
        System.out.println("Append: " + sb);

        sb.insert(0, "Hello ");
        System.out.println("Insert: " + sb);

        sb.reverse();
        System.out.println("Reverse: " + sb);

        sc.close();

	}

}
