package referenceTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string!");
        String str = bufferedReader.readLine();
        System.out.println("Enter substring!");
        String substr = bufferedReader.readLine();
        System.out.println("Enter new substring!");
        String newSubstr = bufferedReader.readLine();

        String newStr = str.replace(substr, newSubstr);
        System.out.println("New string = " + newStr);
    }
}
