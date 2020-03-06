package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        String[] mas = new String[10];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter 8 strings");
        for (int i = 0; i < 8; i++) {
            mas[i] = bufferedReader.readLine();
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            System.out.println(mas[i]);
        }
    }
}
