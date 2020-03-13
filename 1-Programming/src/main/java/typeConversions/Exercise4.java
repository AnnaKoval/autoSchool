package typeConversions;

public class Exercise4 {
    public static void main(String[] args) {
        int a = 0;
        int b = 2;
        int c = 5;

        int newA = a + b;
        int newB = c - a;
        int newC = a + b + c;

        a = newA;
        b = newB;
        c = newC;
    }
}
