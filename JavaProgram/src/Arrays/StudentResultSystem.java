package Arrays;
import java.util.Scanner;

public class StudentResultSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        String[] names = new String[students];
        int[][] marks = new int[students][subjects];
        int[] totals = new int[students];
        double[] averages = new double[students];
        char[] grades = new char[students];

        // Input student names and marks
        for (int i = 0; i < students; i++) {
            sc.nextLine(); // Consume newline

            System.out.print("\nEnter name of Student "+ (i + 1) + ": ");
            names[i] = sc.nextLine();

            int total = 0;

            for (int j = 0; j < subjects; j++) {
                while (true) {
                    System.out.print("Subject "+ (j + 1) + ": ");
                    int mark = sc.nextInt();

                    if (mark >= 0 && mark <= 100) {
                        marks[i][j] = mark;
                        total += mark;
                        break;
                    } else {
                        System.out.println(
                            "Invalid! Enter marks between 0 and 100.");
                    }
                }
            }

            totals[i] = total;
            averages[i] = total / (double) subjects;

            // Grade calculation
            if (averages[i] >= 90)
                grades[i] = 'A';
            else if (averages[i] >= 75)
                grades[i] = 'B';
            else if (averages[i] >= 60)
                grades[i] = 'C';
            else if (averages[i] >= 50)
                grades[i] = 'D';
            else
                grades[i] = 'F';
        }

        // Find topper
        int topperIndex = 0;
        int leastIndex = 0;

        for (int i = 1; i < students; i++) {
            if (totals[i] > totals[topperIndex]) {
                topperIndex = i;
            }

            if (totals[i] < totals[leastIndex]) {
                leastIndex = i;
            }
        }

        // Final report
        System.out.println("\n===== FINAL REPORT =====");
        System.out.print("Name\t");

        for (int j = 0; j < subjects; j++) {
            System.out.print("Sub" + (j + 1) + "\t");
        }

        System.out.println("Total\tAvg\tGrade");

        for (int i = 0; i < students; i++) {
            System.out.print(names[i] + "\t");

            for (int j = 0; j < subjects; j++) {
                System.out.print(marks[i][j] + "\t");
            }

            System.out.println(totals[i] + "\t"
                    + averages[i] + "\t" + grades[i]);
        }

        // Display topper
        System.out.println("\n===== TOPPER =====");
        System.out.println("Name: " + names[topperIndex]);
        System.out.println("Total Marks: " + totals[topperIndex]);
        System.out.println("Average: " + averages[topperIndex]);
        System.out.println("Grade: " + grades[topperIndex]);

        // Display least-scored student
        System.out.println("\n===== LEAST-SCORED STUDENT =====");
        System.out.println("Name: " + names[leastIndex]);
        System.out.println("Total Marks: " + totals[leastIndex]);
        System.out.println("Average: " + averages[leastIndex]);
        System.out.println("Grade: " + grades[leastIndex]);

        sc.close();
    }
}
