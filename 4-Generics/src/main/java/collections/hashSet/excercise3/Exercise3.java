package collections.hashSet.excercise3;

import java.util.HashMap;
import java.util.Map;

public class Exercise3 {
    public static void main(String[] args) {
        HashMap<String, Cat> map = new HashMap<String, Cat>();
        Cat cat1 = new Cat("Tuz");
        Cat cat2 = new Cat("Vasya");
        Cat cat3 = new Cat("Pushok");
        Cat cat4 = new Cat("Tuzik");
        Cat cat5 = new Cat("Iva");
        Cat cat6 = new Cat("Tanyal");
        Cat cat7 = new Cat("Bip");
        Cat cat8 = new Cat("Kotya");
        Cat cat9 = new Cat("Small");
        Cat cat10 = new Cat("Tiger");

        map.put(cat1.getName(), cat1);
        map.put(cat2.getName(), cat2);
        map.put(cat3.getName(), cat3);
        map.put(cat4.getName(), cat4);
        map.put(cat5.getName(), cat5);
        map.put(cat6.getName(), cat6);
        map.put(cat7.getName(), cat7);
        map.put(cat8.getName(), cat8);
        map.put(cat9.getName(), cat9);
        map.put(cat10.getName(), cat10);

        for (Map.Entry<String, Cat> item : map.entrySet()) {
            System.out.println("KEY: " + item.getKey() + ",  VALUE: " + item.getValue());
        }
    }
}
