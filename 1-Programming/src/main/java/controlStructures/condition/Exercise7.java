package controlStructures.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Exercise7 {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        int number = random.nextInt(20 + 1);
        for (int i = 0; i < 7; i++) {
            guess(number);
        }
    }

    public static void guess(int number) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number");
        int n = Integer.parseInt(bufferedReader.readLine());
        if (n < number) {
            System.out.println("Few");
        } else if (n > number) {
            System.out.println("Many");
        } else {
            System.out.println("You won!");
            System.exit(0);
        }
    }
}
