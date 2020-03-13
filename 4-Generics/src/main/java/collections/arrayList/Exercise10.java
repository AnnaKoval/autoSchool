package collections.arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            list.add(0, in.nextLine());
        }

        for (String text : list) {
            System.out.println(text);
        }
    }
}

