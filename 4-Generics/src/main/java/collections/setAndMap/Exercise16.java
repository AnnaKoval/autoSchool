package collections.setAndMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Exercise16 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Susko", "Victor");
        map.put("Vivo", "Sergey");
        map.put("Third", "Ramu");
        map.put("Turic", "Mama");
        map.put("Vivo1", "Sergey");//why Sergey  is displayed?
        map.put("Bob", "Ramu");
        map.put("Ivanov", "Mama");
        map.put("Huty1", "Sergey");
        map.put("Huty2", "Ramu");
        map.put("Huty3", "Mama");

        findAndRemoveDuplicates(map);
        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

    public static void findAndRemoveDuplicates(Map<String, String> map) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            int freqeuncy = Collections.frequency(copy.values(), pair.getValue());
            if (freqeuncy > 1) {
                removePeopleFromMap2(map, pair.getValue());
            }
        }
    }

    public static void removePeopleFromMap2(Map<String, String> map, String name) {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(name))
                map.remove(pair.getKey());
        }
    }
}