package arrays;

import org.apache.commons.lang3.ArrayUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise4 {
    public static void main(String[] args) throws IOException {
        int[] masOfIntegers = new int[10];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter 10 numbers");
        for (int i = 0; i < 10; i++) {
            masOfIntegers[i] = Integer.parseInt(bufferedReader.readLine());
        }
        ArrayUtils.reverse(masOfIntegers);
        System.out.println(Arrays.toString(masOfIntegers));
    }
}
