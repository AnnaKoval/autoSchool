package collections.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Scanner in = new Scanner(System.in);
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());
        int maxSize = 0;
        for (String text : list) {
            if (maxSize < text.length()) {
                maxSize = text.length();
            }
        }
        for (String text : list) {
            if (maxSize == text.length()) {
                System.out.println(text);
            }
        }
    }
}
