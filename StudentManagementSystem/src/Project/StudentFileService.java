package Project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class StudentFileService {

    public void saveStudents(HashMap<Integer, Student> students) {

        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(
                        new FileOutputStream("students.dat")
                    );

            out.writeObject(students);
            out.close();

            System.out.println("Student records saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap<Integer, Student> loadStudents() {

        try {
            ObjectInputStream in =
                    new ObjectInputStream(
                        new FileInputStream("students.dat")
                    );

            HashMap<Integer, Student> students =
                    (HashMap<Integer, Student>) in.readObject();

            in.close();

            System.out.println("Student records loaded successfully!");

            return students;

        } catch (Exception e) {
            System.out.println("No previous records found.");
            return new HashMap<Integer, Student>();
        }
    }

    public void saveReportCard(int id, String report) {

        try {
            FileWriter writer =
                    new FileWriter("ReportCard_" + id + ".txt");

            writer.write(report);
            writer.close();

            System.out.println(
                "Report card saved as ReportCard_" + id + ".txt"
            );

        } catch (IOException e) {
            System.out.println("Error saving report card: " + e.getMessage());
        }
    }
}