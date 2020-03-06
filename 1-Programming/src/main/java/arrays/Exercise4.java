package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        int[] masOfIntegers = new int[10];
        int[] masOfIntegersReverse = new int[10];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter 10 numbers");
        for (int i = 0; i < 10; i++) {
            masOfIntegers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 9; j >= 0; j--) {
                masOfIntegersReverse[i] = masOfIntegers[j];
                i++;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(masOfIntegersReverse[i]);
        }
    }
}
