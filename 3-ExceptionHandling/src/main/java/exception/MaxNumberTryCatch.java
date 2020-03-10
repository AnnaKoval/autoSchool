package exception;

public class MaxNumberTryCatch {
    public static int max(int[] arr) {
        int max = arr[0];
        try {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
            }
            Thread.sleep(3000);
            int zero = 5 / 0;
        } catch (InterruptedException ex) {
            System.out.println("Exception!!!");
        } catch (ArithmeticException ex) {
            System.out.println("You shall not fall!!!");
        }
        return max;
    }
}
