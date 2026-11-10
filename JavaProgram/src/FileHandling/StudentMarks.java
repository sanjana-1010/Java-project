package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentMarks {

    public static void main(String[] args) {

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        int total = 0;
        int count = 0;
        int above80 = 0;

        String highestStudent = "";
        String lowestStudent = "";

        try {
            BufferedReader br =
                    new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int marks = Integer.parseInt(data[2]);

                System.out.println(id + " " + name + " " + marks);

                total += marks;
                count++;

                if (marks > highest) {
                    highest = marks;
                    highestStudent = name;
                }

                if (marks < lowest) {
                    lowest = marks;
                    lowestStudent = name;
                }

                if (marks > 80) {
                    above80++;
                }
            }

            br.close();

            double average = (double) total / count;

            System.out.println("\nHighest: "
                    + highestStudent + " - " + highest);

            System.out.println("Lowest: "
                    + lowestStudent + " - " + lowest);

            System.out.println("Average: " + average);

            System.out.println("Students above 80: " + above80);

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
