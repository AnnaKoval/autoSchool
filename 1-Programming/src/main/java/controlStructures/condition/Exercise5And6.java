package controlStructures.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5And6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        int age = Integer.parseInt(bufferedReader.readLine());
        if (age < 18) {
            System.out.println("Still grow");
        } else if (age > 20) {
            System.out.println("And 18 is enough");
        }
    }
}
