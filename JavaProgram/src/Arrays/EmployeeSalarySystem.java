package Arrays;
import java.util.Scanner;

public class EmployeeSalarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int employees = sc.nextInt();

        System.out.print("Enter number of months: ");
        int months = sc.nextInt();

        String[] names = new String[employees];
        int[][] salary = new int[employees][months];
        int[] totals = new int[employees];
        double[] averages = new double[employees];

        // Input employee names and salaries
        for (int i = 0; i < employees; i++) {
            sc.nextLine();

            System.out.print("\nEnter employee name: ");
            names[i] = sc.nextLine();

            int total = 0;

            for (int j = 0; j < months; j++) {
                System.out.print("Enter salary for month "
                        + (j + 1) + ": ");
                salary[i][j] = sc.nextInt();

                total += salary[i][j];
            }

            totals[i] = total;
            averages[i] = total / (double) months;
        }

        // Find highest-paid and least-paid employees
        int highestIndex = 0;
        int leastIndex = 0;

        for (int i = 1; i < employees; i++) {
            if (totals[i] > totals[highestIndex]) {
                highestIndex = i;
            }

            if (totals[i] < totals[leastIndex]) {
                leastIndex = i;
            }
        }

        // Display employee report
        System.out.println("\n===== EMPLOYEE SALARY REPORT =====");
        System.out.print("Name\t");

        for (int j = 0; j < months; j++) {
            System.out.print("Month" + (j + 1) + "\t");
        }

        System.out.println("Total\tAverage");

        for (int i = 0; i < employees; i++) {
            System.out.print(names[i] + "\t");

            for (int j = 0; j < months; j++) {
                System.out.print(salary[i][j] + "\t");
            }

            System.out.println(totals[i] + "\t"
                    + averages[i]);
        }

        // Highest-paid employee
        System.out.println("\n===== HIGHEST-PAID EMPLOYEE =====");
        System.out.println("Name: " + names[highestIndex]);
        System.out.println("Total Salary: "
                + totals[highestIndex]);

        // Least-paid employee
        System.out.println("\n===== LEAST-PAID EMPLOYEE =====");
        System.out.println("Name: " + names[leastIndex]);
        System.out.println("Total Salary: "
                + totals[leastIndex]);

        sc.close();
    }
}
