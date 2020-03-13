package collections.hashSet;

import java.util.HashMap;
import java.util.Map;

public class Exercise6 {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("watermelon", "berry");
        map.put("banana", 1);
        map.put("cherry", -2);
        map.put("pear", 1.4);
        map.put("melon", 'v');
        map.put("blackberry", true);
        map.put("ginseng", false);
        map.put("strawberry", new Exception());
        map.put("iris", "flower");
        map.put("potato", true);

        for (Map.Entry<String, Object> item : map.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }
}
