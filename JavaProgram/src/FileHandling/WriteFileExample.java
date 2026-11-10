package FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {

    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("student.txt");

            writer.write("Student ID: 101\n");
            writer.write("Name: Rahul\n");
            writer.write("Course: Java\n");
            writer.write("Marks: 85\n");

            writer.close();

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing file.");
        }
    }
}
