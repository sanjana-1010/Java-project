package JavaStream;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(40, 10, 30, 20);

        numbers.stream()
               .sorted()
               .forEach(System.out::println);
    }
}
