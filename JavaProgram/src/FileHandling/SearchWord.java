package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter word to search: ");
        String searchWord = sc.nextLine();

        int lineNumber = 0;
        int count = 0;

        try {
            BufferedReader br =
                    new BufferedReader(new FileReader("article.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                lineNumber++;

                String[] words = line.split("\\s+");

                for (String word : words) {

                    if (word.equalsIgnoreCase(searchWord)) {
                        count++;

                        System.out.println(
                                searchWord + " found in line " + lineNumber
                        );
                    }
                }
            }

            br.close();

            System.out.println("Total occurrences: " + count);

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        sc.close();
    }
}