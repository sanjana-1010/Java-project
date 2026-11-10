package JavaStream;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4);

        numbers.stream()
               .distinct()
               .forEach(System.out::println);
    }
}
