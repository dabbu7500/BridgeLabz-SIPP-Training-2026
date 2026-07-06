import java.util.Scanner;

public class TrimSpaces {
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[] {start, end + 1};
    }

    public static String createSubstring(String text, int start, int end) {
        StringBuilder builder = new StringBuilder();
        for (int index = start; index < end; index++) {
            builder.append(text.charAt(index));
        }
        return builder.toString();
    }

    public static boolean compareStrings(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        for (int index = 0; index < first.length(); index++) {
            if (first.charAt(index) != second.charAt(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text with leading/trailing spaces: ");
        String text = scanner.nextLine();

        int[] indexes = findTrimIndexes(text);
        String userDefinedTrim = createSubstring(text, indexes[0], indexes[1]);
        String builtInTrim = text.trim();

        System.out.println("Trimmed text using user-defined method: '" + userDefinedTrim + "'");
        System.out.println("Trimmed text using built-in trim(): '" + builtInTrim + "'");
        System.out.println("Both strings are equal: " + compareStrings(userDefinedTrim, builtInTrim));
        scanner.close();
    }
}
