package JavaStream;

import java.util.*;
import java.util.stream.*;

public class StoreFilteredData {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ram", "John", "Arun");

        List<String> result = names.stream()
                                   .filter(name -> name.startsWith("R"))
                                   .collect(Collectors.toList());

        System.out.println(result);
    }
}
