package Javacls;

import java.util.Scanner;

public class Operators {

	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a: ");
	        int a = sc.nextInt();

	        System.out.print("Enter b: ");
	        int b = sc.nextInt();

	        // Arithmetic operators
	        System.out.println("Addition: " + (a + b));
	        System.out.println("Subtraction: " + (a - b));
	        System.out.println("Multiplication: " + (a * b));

	        if (b != 0) {
	            System.out.println("Division: " + (a / b));
	            System.out.println("Modulus: " + (a % b));
	        } else {
	            System.out.println("Division and modulus by zero are not allowed.");
	        }

	        // Relational operators
	        System.out.println("a > b: " + (a > b));
	        System.out.println("a < b: " + (a < b));
	        System.out.println("a == b: " + (a == b));
	        System.out.println("a != b: " + (a != b));

	        // Logical operators
	        System.out.println("AND: " + (a > 0 && b > 0));
	        System.out.println("OR: " + (a > 0 || b > 0));
	        System.out.println("NOT: " + !(a > b));

	        // Assignment operators
	        int c = a;
	        c += b;
	        System.out.println("Addition assignment: " + c);

	        c = a;
	        c -= b;
	        System.out.println("Subtraction assignment: " + c);

	        c = a;
	        c *= b;
	        System.out.println("Multiplication assignment: " + c);

	        if (b != 0) {
	            c = a;
	            c /= b;
	            System.out.println("Division assignment: " + c);

	            c = a;
	            c %= b;
	            System.out.println("Modulus assignment: " + c);
	        }

	        // Unary operators
	        int x = a;
	        System.out.println("Pre-increment: " + (++x));
	        System.out.println("Post-increment: " + (x++));
	        System.out.println("After increment: " + x);
	        System.out.println("Pre-decrement: " + (--x));

	        // Bitwise operators
	        System.out.println("Bitwise AND: " + (a & b));
	        System.out.println("Bitwise OR: " + (a | b));
	        System.out.println("Bitwise XOR: " + (a ^ b));

	        // Shift operators
	        System.out.println("Left shift: " + (a << 1));
	        System.out.println("Right shift: " + (a >> 1));

	        // Ternary operator
	        int max = (a > b) ? a : b;
	        System.out.println("Maximum: " + max);

	        sc.close();

	}

}
