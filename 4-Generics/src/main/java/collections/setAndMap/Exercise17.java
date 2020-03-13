package collections.setAndMap;

import java.util.HashMap;
import java.util.Map;

public class Exercise17 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Ivanov1", "Victor");
        map.put("Ivanov2", "Victor");
        map.put("Ivanov3", "Victor");
        map.put("Turic", "Victor");
        map.put("Ivanov4", "Victor");
        map.put("Ivanov5", "Victor");
        map.put("Ivanov6", "Mama");
        map.put("Huty", "Sergey");
        map.put("Ivanov7", "Ramu");
        map.put("Huty", "Mama");

        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
