package Arrays;
import java.util.Scanner;

public class PatientTemperatureSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int patients = sc.nextInt();

        int days = 3;

        String[] names = new String[patients];
        double[][] temperature = new double[patients][days];

        // Input patient names and temperatures
        for (int i = 0; i < patients; i++) {
            sc.nextLine();

            System.out.print("\nEnter patient name: ");
            names[i] = sc.nextLine();

            for (int j = 0; j < days; j++) {
                System.out.print("Enter temperature for Day "
                        + (j + 1) + " (Fahrenheit): ");
                temperature[i][j] = sc.nextDouble();
            }
        }

        // Display temperature report
        System.out.println("\n===== PATIENT TEMPERATURE REPORT =====");

        for (int i = 0; i < patients; i++) {
            System.out.println("\nPatient: " + names[i]);

            boolean fever = false;
            boolean feverAllDays = true;

            for (int j = 0; j < days; j++) {
                System.out.println("Day " + (j + 1) + ": "
                        + temperature[i][j] + " F");

                if (temperature[i][j] >= 100.4) {
                    fever = true;
                } else {
                    feverAllDays = false;
                }
            }

            if (fever) {
                System.out.println("Status: Fever detected");

                if (feverAllDays) {
                    System.out.println(
                        "Action: Doctor should review continued treatment");
                } else {
                    System.out.println(
                        "Action: Monitor temperature and consult doctor");
                }
            } else {
                System.out.println("Status: No fever detected");
                System.out.println(
                    "Action: Follow doctor's treatment advice");
            }
        }

        sc.close();
    }
}
