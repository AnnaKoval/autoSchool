package controlStructures.loopsWhile;

public class Exercise11 {
    public static void main(String[] args) {
        int x = 1, y = 1;
        while (y <= 10)
        {
            while (x < 10)
            {
                System.out.print("S"); x++;
            }
            System.out.println("S"); y++; x=1;
        }
    }
}
