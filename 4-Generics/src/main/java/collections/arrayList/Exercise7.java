package collections.arrayList;

import java.util.ArrayList;

public class Exercise7 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        list.add("str5");
        System.out.println(list.size());
        for (String text : list) {
            System.out.println(text);
        }
    }
}
