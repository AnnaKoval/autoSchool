package controlStructures.loopsWhile;

public class Exercise12 {
    public static void main(String[] args) {
        int count = 1, n1 = 1;
        while (count < 11) {
            System.out.println(multiplication(n1++));
            count++;
        }
    }

    public static String multiplication(int n2) {
        int count = 1, n1 = 1;
        String n = "";
        while (count < 11) {
            System.out.print(n1 * n2 + " ");
            count++;
            n1++;
        }
        return n;
    }
}
