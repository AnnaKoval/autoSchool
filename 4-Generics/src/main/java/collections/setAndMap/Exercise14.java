package collections.setAndMap;

import java.util.*;

public class Exercise14 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Susko", "Mama");
        map.put("Ivanov", "Sergey");
        map.put("Third", "Ramu");
        map.put("Turic", "Mama");
        map.put("Vivo", "Sergey");
        map.put("Bob", "Ramu");
        map.put("Ivanov", "Mama");
        map.put("Huty", "Sergey");
        map.put("Huty", "Ramu");
        map.put("Huty", "Mama");

        System.out.println("Set has " + Collections.frequency(map.values(), "Mama") + " people with name Mama");
        System.out.println("Set has " + Collections.frequency(map.keySet(), "Susko") + " people with last name Susko");
    }
}