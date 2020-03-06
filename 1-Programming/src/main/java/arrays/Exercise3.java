package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        String[] masOfStrings = new String[10];
        int[] masOfIntegers = new int[20];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter 10 strings");
        for (int i = 0; i < 10; i++)
        {
            masOfStrings[i] = bufferedReader.readLine();
        }
        for (int i = 0; i < 10; i++) {
                masOfIntegers[i] = masOfStrings[i].length();
        }
        for (int i = 0; i < 10; i++)
        {
            System.out.println(masOfIntegers[i]);
        }
    }
}
