package streamAPI;

import java.util.Arrays;
import java.util.List;

public class Practic {
    public static void main(String[] args) {
        List<String> list = initialize();

        printLengthOfElement(list);
        notEmptyElementWithoutD(list);
        printInAlphabeticOrder(list);
    }

    public static void printInAlphabeticOrder(List<String> list) {
        list.stream()
                .sorted()
                .forEach(i -> System.out.println(i));
    }

    public static void notEmptyElementWithoutD(List<String> list) {
        list.stream()
                .filter(i -> !i.isEmpty() && !i.contains("d"))
                .forEach(System.out::println);
    }

    public static void printLengthOfElement(List<String> list) {
        list.stream()
                .forEach((i) -> System.out.println(i.length()));
    }

    public static List<String> initialize() {
        List<String> list = Arrays.asList("", "A", "", "C", "b", "str1", "str2", "str3",
                "str4", "str5", "str1", "str2", "str3", "str4", "", "str1", "str2", "str3", "str4", "str5", "str1", "str2", "str3",
                "str4", "str5", "str1", "str2", "str3", "str4", "str5", "str1", "a", "str3", "str4", "str5", "str1", "str2", "ftr3",
                "str4", "str5", "str1", "str2", "str3", "str4", "str5", "str1", "drf", "str3", "str4", "d");
        return list;
    }
}
