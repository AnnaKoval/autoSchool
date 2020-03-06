package controlStructures.loopsFor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((System.in)));
        String name = bufferedReader.readLine();
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " loves me");
        }
    }
}
