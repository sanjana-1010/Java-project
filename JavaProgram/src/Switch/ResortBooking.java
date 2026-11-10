package Switch;

import java.util.Scanner;

public class ResortBooking {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Standard Room - Rs. 2000/day");
        System.out.println("2. Deluxe Room - Rs. 3000/day");
        System.out.println("3. Suite Room - Rs. 5000/day");

        System.out.print("Choose room type: ");
        int room = sc.nextInt();

        switch (room) {
            case 1:
                System.out.println("Standard Room selected");
                System.out.println("1. 1 day");
                System.out.println("2. 2 days");
                System.out.println("3. 3 days");

                System.out.print("Choose duration: ");
                int days1 = sc.nextInt();

                switch (days1) {
                    case 1:
                        System.out.println("Total = Rs. 2000");
                        break;
                    case 2:
                        System.out.println("Total = Rs. 4000");
                        break;
                    case 3:
                        System.out.println("Total = Rs. 6000");
                        break;
                    default:
                        System.out.println("Invalid duration");
                }
                break;

            case 2:
                System.out.println("Deluxe Room selected");
                System.out.println("1. 1 day");
                System.out.println("2. 2 days");
                System.out.println("3. 3 days");

                System.out.print("Choose duration: ");
                int days2 = sc.nextInt();

                switch (days2) {
                    case 1:
                        System.out.println("Total = Rs. 3000");
                        break;
                    case 2:
                        System.out.println("Total = Rs. 6000");
                        break;
                    case 3:
                        System.out.println("Total = Rs. 9000");
                        break;
                    default:
                        System.out.println("Invalid duration");
                }
                break;

            case 3:
                System.out.println("Suite Room selected");
                System.out.println("1. 1 day");
                System.out.println("2. 2 days");
                System.out.println("3. 3 days");

                System.out.print("Choose duration: ");
                int days3 = sc.nextInt();

                switch (days3) {
                    case 1:
                        System.out.println("Total = Rs. 5000");
                        break;
                    case 2:
                        System.out.println("Total = Rs. 10000");
                        break;
                    case 3:
                        System.out.println("Total = Rs. 15000");
                        break;
                    default:
                        System.out.println("Invalid duration");
                }
                break;

            default:
                System.out.println("Invalid room type");
        }

        sc.close();

	}

}
