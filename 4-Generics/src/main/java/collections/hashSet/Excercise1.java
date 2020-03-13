package collections.hashSet;

import java.util.Arrays;
import java.util.HashSet;

public class Excercise1 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>(Arrays.asList("watermelon", "banana", "cherry", "pear", "melon", "blackberry", "ginseng", "strawberry", "iris", "potato"));

        for (String text : set) {
            System.out.println(text);
        }
    }
}
