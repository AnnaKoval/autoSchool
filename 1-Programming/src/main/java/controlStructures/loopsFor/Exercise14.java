package controlStructures.loopsFor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise14 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bufferedReader.readLine());
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
