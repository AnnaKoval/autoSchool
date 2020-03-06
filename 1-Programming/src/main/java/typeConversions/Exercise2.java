package typeConversions;

public class Exercise2 {
    public static void main(String[] args) {
        int n=67;
        int decNumber=n/10;
        int plainNumber=n-(decNumber*10);
        int sum=decNumber+plainNumber;

        System.out.println(decNumber+" and "+plainNumber+" = "+sum);
    }
}
