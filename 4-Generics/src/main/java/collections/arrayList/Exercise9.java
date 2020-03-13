package collections.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        list.add(str1);
        for (int i = 0; i < 4; i++) {
            list.add(in.nextLine());
        }
        int minSize = str1.length();
        for (String text : list) {
            if (minSize > text.length()) {
                minSize = text.length();
            }
        }
        for (String text : list) {
            if (minSize == text.length()) {
                System.out.println(text);
            }
        }
    }
}

