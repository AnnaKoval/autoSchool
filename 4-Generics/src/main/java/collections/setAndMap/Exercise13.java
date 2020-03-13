package collections.setAndMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercise13 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 21; i++) {
            set.add(i);
        }

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number > 10) {
                iterator.remove();
            }
        }
        for (int i : set)
            System.out.println(i);
    }
}
