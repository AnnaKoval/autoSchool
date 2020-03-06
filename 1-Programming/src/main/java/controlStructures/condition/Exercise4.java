package controlStructures.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = bufferedReader.readLine();
        String name2 = bufferedReader.readLine();
        if (name1.equals(name2)) {
            System.out.println("Names are identical");
        } else if (name1.length() == name2.length()) {
            System.out.println("Name lengths are equal");
        }
    }
}
