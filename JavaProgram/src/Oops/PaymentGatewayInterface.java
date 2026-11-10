package Oops;

import java.util.Scanner;


class UpiPayment implements PaymentGateway {

public void makePayment(double amount) {
   System.out.println("Paid Rs. " + amount + " using UPI");
}

public void paymentStatus() {
   System.out.println("UPI Payment Successful!");
}
}


class CreditCard implements PaymentGateway {

public void makePayment(double amount) {
   System.out.println("Paid Rs. " + amount + " using Credit Card");
}

public void paymentStatus() {
   System.out.println("Credit Card Payment Successful!");
}
}


class DebitCard implements PaymentGateway {

public void makePayment(double amount) {
   System.out.println("Paid Rs. " + amount + " using Debit Card");
}

public void paymentStatus() {
   System.out.println("Debit Card Payment Successful!");
}
}


class NetBanking implements PaymentGateway {

public void makePayment(double amount) {
   System.out.println("Paid Rs. " + amount + " using Net Banking");
}

public void paymentStatus() {
   System.out.println("Net Banking Payment Successful!");
}
}

public class PaymentGatewayInterface {

 public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);

     System.out.println("===== PAYMENT GATEWAY =====");
     System.out.println("1. UPI Payment");
     System.out.println("2. Credit Card");
     System.out.println("3. Debit Card");
     System.out.println("4. Net Banking");

     System.out.print("Enter Your Choice: ");
     int choice = sc.nextInt();

     System.out.print("Enter Amount: ");
     double amount = sc.nextDouble();

     PaymentGateway p;

     if (choice == 1) {
         p = new UpiPayment();
     }
     else if (choice == 2) {
         p = new CreditCard();
     }
     else if (choice == 3) {
         p = new DebitCard();
     }
     else if (choice == 4) {
         p = new NetBanking();
     }
     else {
         System.out.println("Invalid Choice!");
         sc.close();
         return;
     }

     p.makePayment(amount);
     p.paymentStatus();

     sc.close();
 }
}


