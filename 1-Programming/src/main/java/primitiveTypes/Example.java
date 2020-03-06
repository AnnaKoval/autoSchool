package primitiveTypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, world!");
        printHelloName();
    }

    public static void printHelloName() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name!");
        String name = bufferedReader.readLine();
        System.out.println("Hello, " + name);
    }
}
