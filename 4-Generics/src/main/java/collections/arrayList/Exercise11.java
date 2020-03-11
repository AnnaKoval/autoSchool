package collections.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());
        list.add(in.nextLine());

        for (int i = 0; i < 13; i++) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            i++;
        }

        for (String text : list) {
            System.out.println(text);
        }
    }
}

