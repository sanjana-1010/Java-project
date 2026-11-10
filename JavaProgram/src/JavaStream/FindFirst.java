package JavaStream;

import java.util.*;

public class FindFirst {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ram", "John", "Arun");

        String first = names.stream()
                            .findFirst()
                            .get();

        System.out.println(first);
    }
}
