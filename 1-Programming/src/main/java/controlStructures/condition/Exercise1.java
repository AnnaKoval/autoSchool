package controlStructures.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(bufferedReader.readLine());
        int number2 = Integer.parseInt(bufferedReader.readLine());
        if (number1 > number2) {
            System.out.println(number2);
        } else if (number1 == number2) {
            System.out.println("numbers are equal");
        } else {
            System.out.println(number1);
        }
    }
}
