package controlStructures.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(bufferedReader.readLine());
        int number2 = Integer.parseInt(bufferedReader.readLine());
        int number3 = Integer.parseInt(bufferedReader.readLine());
        if (number1 >= number2 && number1 >= number3 && number2 > number3) {
            System.out.println(number1 + " " + number2 + " " + number3);
        } else if (number1 >= number2 && number3 >= number2 && number1 >= number3) {
            System.out.println(number1 + " " + number3 + " " + number2);
        } else if (number2 >= number1 && number2 >= number3 && number1 >= number3) {
            System.out.println(number2 + " " + number1 + " " + number3);
        } else if (number2 >= number1 && number2 >= number3 && number3 >= number1) {
            System.out.println(number2 + " " + number3 + " " + number1);
        } else if (number3 >= number1 && number3 >= number2 && number1 >= number2) {
            System.out.println(number3 + " " + number1 + " " + number2);
        } else if (number3 >= number1 && number3 >= number2 && number2 >= number1) {
            System.out.println(number3 + " " + number2 + " " + number1);
        }
    }
}
