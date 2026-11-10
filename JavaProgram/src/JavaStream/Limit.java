package JavaStream;

import java.util.*;

public class Limit {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.stream()
               .limit(3)
               .forEach(System.out::println);
    }
}
