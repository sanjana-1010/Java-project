package Methods;
import java.util.Scanner;

public class HouseSystem {

    // Method to calculate 1BHK rent
    double calculate1BHK(double rent, int months) {
        return rent * months;
    }

    // Method to calculate 2BHK rent
    double calculate2BHK(double rent, int months) {
        return rent * months;
    }

    // Method to calculate lease amount
    double calculateLease(double leaseAmount) {
        return leaseAmount;
    }

    // Method to display details
    void display(String name, String type, double amount) {
        System.out.println("\nOwner Name: " + name);
        System.out.println("House Type: " + type);
        System.out.println("Total Amount: Rs." + amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HouseSystem h = new HouseSystem();

        int choice;

        do {
            System.out.println("\n===== HOUSE RENT MENU =====");
            System.out.println("1. Calculate 1BHK Rent");
            System.out.println("2. Calculate 2BHK Rent");
            System.out.println("3. Calculate Lease Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter owner name: ");
                    String owner1 = sc.nextLine();

                    System.out.print("Enter monthly rent: ");
                    double rent1 = sc.nextDouble();

                    System.out.print("Enter number of months: ");
                    int months1 = sc.nextInt();

                    double total1 =
                            h.calculate1BHK(rent1, months1);

                    h.display(owner1, "1BHK", total1);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter owner name: ");
                    String owner2 = sc.nextLine();

                    System.out.print("Enter monthly rent: ");
                    double rent2 = sc.nextDouble();

                    System.out.print("Enter number of months: ");
                    int months2 = sc.nextInt();

                    double total2 =
                            h.calculate2BHK(rent2, months2);

                    h.display(owner2, "2BHK", total2);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter owner name: ");
                    String owner3 = sc.nextLine();

                    System.out.print("Enter lease amount: ");
                    double lease = sc.nextDouble();

                    double total3 =
                            h.calculateLease(lease);

                    h.display(owner3, "Lease House", total3);
                    break;

                case 4:
                    System.out.println(
                            "Thank you for using House System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
