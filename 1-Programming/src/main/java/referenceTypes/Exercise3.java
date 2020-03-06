package referenceTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string with spaces ");
        String strWithSpaces = bufferedReader.readLine();

        String[] arrStr = strWithSpaces.split(" ");
        String maxStr = "";
        for (String word : arrStr) {
            if (word.length() > maxStr.length())
                maxStr = word;
        }
        System.out.println(maxStr);
    }
}
