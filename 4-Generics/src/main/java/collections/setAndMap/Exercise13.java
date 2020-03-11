package collections.setAndMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Exercise13 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(9);
        set.add(8);
        set.add(11);
        set.add(10);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(15);
        set.add(15);
        set.add(17);
        set.add(18);
        set.add(19);
        set.add(20);

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
