package collections.setAndMap;

import java.util.HashMap;
import java.util.Map;

public class Exercise17 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivanov", "Victor");
        map.put("Ivanov", "Victor");
        map.put("Ivanov", "Victor");
        map.put("Turic", "Victor");
        map.put("Ivanov", "Victor");
        map.put("Ivanov", "Victor");
        map.put("Ivanov", "Mama");
        map.put("Huty", "Sergey");
        map.put("Ivanov", "Ramu");
        map.put("Huty", "Mama");

        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
