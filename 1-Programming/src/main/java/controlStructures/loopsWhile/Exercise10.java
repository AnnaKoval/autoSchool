package controlStructures.loopsWhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String str=bufferedReader.readLine();
        int n=Integer.parseInt(bufferedReader.readLine());
        while (n!=0){
            System.out.println(str);
            n--;
        }
    }
}
