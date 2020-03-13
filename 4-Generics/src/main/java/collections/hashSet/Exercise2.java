package collections.hashSet;

import java.util.HashMap;
import java.util.Map;

public class Exercise2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("watermelon", "berry");
        map.put("banana", "grass");
        map.put("cherry", "berry");
        map.put("pear", "fruit");
        map.put("melon", "vegetable");
        map.put("blackberry", "bush");
        map.put("ginseng", "root");
        map.put("strawberry", "berry");
        map.put("iris", "flower");
        map.put("potato", "tuber");

        for (Map.Entry<String, String> pair : map.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + "-" + value);
        }
    }
}
