import java.util.Scanner;

public class StringLength {
    public static int findLengthWithoutLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException exception) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String text = scanner.next();

        int userDefinedLength = findLengthWithoutLength(text);
        int builtInLength = text.length();

        System.out.println("Length using user-defined method: " + userDefinedLength);
        System.out.println("Length using built-in length(): " + builtInLength);
        scanner.close();
    }
}
