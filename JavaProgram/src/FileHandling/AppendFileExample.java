package FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class AppendFileExample {

    public static void main(String[] args) {

        try {
            FileWriter writer =new FileWriter("employees.txt", true);

            writer.write("104 - Rose\n");
            writer.write("105 - Ravi\n");

            writer.close();

            System.out.println("Data appended successfully.");

        } catch (IOException e) {
            System.out.println("Error while appending data.");
        }
    }
}
