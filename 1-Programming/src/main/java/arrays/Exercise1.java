package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        int[] mas = initializeArray();
        int maxNumber=max(mas);
        System.out.println("Max number = "+maxNumber);
    }

    public static int[] initializeArray() throws IOException {
        int[] mas = new int[20];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter 20 numbers");
        for (int i = 0; i < mas.length; i++)
        {
            mas[i] = Integer.parseInt(bufferedReader.readLine());
        }
        return mas;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
}
