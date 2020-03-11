package collections.hashSet;

import java.util.HashSet;

public class Excercise1 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("watermelon");
        set.add("banana");
        set.add("cherry");
        set.add("pear");
        set.add("melon");
        set.add("blackberry");
        set.add("ginseng");
        set.add("strawberry");
        set.add("iris");
        set.add("potato");

        for (String text : set) {
            System.out.println(text);
        }
    }
}
