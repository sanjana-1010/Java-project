package JavaStream;

import java.util.*;

public class Stream12 {
    public static void main(String[] args) {

        List<String> names = List.of("kala", "mala", "ram", "sita");

        List<String> result = names.stream()
                                   .filter(name -> name.length() > 4)
                                   .map(String::toUpperCase)
                                   .sorted()
                                   .toList();

        System.out.println(result);
    }
}
