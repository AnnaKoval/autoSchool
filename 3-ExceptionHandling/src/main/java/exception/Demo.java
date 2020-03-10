package exception;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        MaxNumberThrows maxNumberThrows = new MaxNumberThrows();
        int[] mas = maxNumberThrows.initializeArray();
        int maxNumber = maxNumberThrows.max(mas);
        System.out.println("Max number = " + maxNumber);

        System.out.println();
        MaxNumberTryCatch maxNumberTryCatch = new MaxNumberTryCatch();
        int maxNumber2 = maxNumberTryCatch.max(mas);
        System.out.println("Max number = " + maxNumber2);
    }
}
