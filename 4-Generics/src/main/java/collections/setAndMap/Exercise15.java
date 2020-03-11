package collections.setAndMap;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.time.Month.*;

public class Exercise15 {
    public static void main(String[] args) {
        HashMap<String, LocalDate> map = new HashMap<>();
        map.put("Susko", LocalDate.of(1999, 8, 10));
        map.put("Ivan", LocalDate.of(1988, 5, 2));
        map.put("Third", LocalDate.of(1900, 8, 2));
        map.put("Turic", LocalDate.of(2000, 6, 2));
        map.put("Vivo", LocalDate.of(2010, 7, 2));
        map.put("Bob", LocalDate.of(1967, 2, 2));
        map.put("Kovn", LocalDate.of(1987, 1, 2));
        map.put("Huty", LocalDate.of(1996, 4, 2));
        map.put("Pover", LocalDate.of(1967, 9, 2));
        map.put("Goovko", LocalDate.now());

        removeAllSummerPeople(map);
        for (Map.Entry<String, LocalDate> item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }

    public static void removeAllSummerPeople(HashMap<String, LocalDate> map) {
        Iterator<Map.Entry<String, LocalDate>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Month month = iterator.next().getValue().getMonth();
            if (month == JUNE || month == JULY || month == AUGUST) {
                iterator.remove();
            }
        }
    }
}