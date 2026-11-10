package JavaStream;

import java.util.*;

public class Sum {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30);

        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);
    }
}
