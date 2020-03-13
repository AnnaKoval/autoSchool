package referenceTypes;

public class Exercise1 {
    public static void main(String[] args) {
        String str = "j.a gf .gj";
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
            System.out.println("Last element " + result[result.length - 1]);
        } else if (result.length != 1) {
            int average = result.length / 2;
            System.out.println("Average number = " + result[average]);
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
        int count = -1;
        char[] result = str.toCharArray();

        for (String part : str.split(" ")) {
            count++;
        }

        if (result[str.length() - 1] == ' ') {
            count++;
        }
        System.out.println("Quantity of spaces = " + count);
    }
}
