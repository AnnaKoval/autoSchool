package referenceTypes;

public class Exercise1 {
    public static void main(String[] args) {
        String str = ".a gf .g";
        findElements(str);
        writeStrWithDot(str);
        countSpaces(str);
    }

    public static void findElements(String str) {
        char[] result = str.toCharArray();
        System.out.println("Char array:");

        System.out.println("1 element " + result[0]);

        if (result.length % 2 == 0 && result.length != 1) {
            System.out.println("No average number");
        } else {
            int average = result.length / 2;
            System.out.println("Average number = " + result[average]);
        }

        if (result.length != 1) {
            System.out.println("Last element " + result[result.length - 1]);
        } else {
            System.out.println("First element = last element");
        }
    }

    public static void writeStrWithDot(String str) {
        int index = str.indexOf(".");
        System.out.println(str.substring(0, index + 1));
    }

    public static void countSpaces(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println("Quantity of spaces = " + count);
    }
}
