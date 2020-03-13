package controlStructures.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] mas = new int[4];
        for (int i = 0; i < 4; i++) {
            mas[i] = Integer.parseInt(bufferedReader.readLine());
        }
        if (mas[0] >= mas[1] && mas[0] >= mas[2] && mas[0] > mas[3]) {
            System.out.println(mas[0]);
        } else if (mas[1] >= mas[0] && mas[1] >= mas[2] && mas[1] >= mas[3]) {
            System.out.println(mas[1]);
        } else if (mas[2] >= mas[0] && mas[2] >= mas[1] && mas[2] >= mas[3]) {
            System.out.println(mas[2]);
        } else if (mas[3] >= mas[0] && mas[3] >= mas[1] && mas[3] >= mas[2]) {
            System.out.println(mas[3]);
        }
    }
}
