package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Exercise5 {
    public static void main(String[] args) throws IOException {
        int[] bigMas = new int[20];
        int[] smallMas1 = new int[10];
        int[] smallMas2 = new int[10];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter 20 numbers");
        for (int i = 0; i < 20; i++)
        {
            bigMas[i] = Integer.parseInt(bufferedReader.readLine());
        }
        smallMas1= Arrays.copyOfRange(bigMas, 0, 9);
        smallMas2= Arrays.copyOfRange(bigMas, 10, 20);

        for (int i = 0; i < 10; i++)
        {
            System.out.println(smallMas2[i]);
        }
    }
}
