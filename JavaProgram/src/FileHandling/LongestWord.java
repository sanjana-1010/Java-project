package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestWord {

    public static void main(String[] args) {

        String longestWord = "";

        try {
            BufferedReader br =
                    new BufferedReader(new FileReader("input.txt"));

            String line;

            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (String word : words) {

                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }

            br.close();

            System.out.println("Longest word: " + longestWord);
            System.out.println("Length: " + longestWord.length());

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
