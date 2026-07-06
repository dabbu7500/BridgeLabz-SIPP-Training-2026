import java.util.Scanner;

public class SplitCompare {
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

    public static String[] splitIntoWords(String text) {
        int textLength = findLengthWithoutLength(text);
        int wordCount = 0;
        boolean insideWord = false;

        for (int index = 0; index < textLength; index++) {
            if (text.charAt(index) != ' ' && !insideWord) {
                wordCount++;
                insideWord = true;
            } else if (text.charAt(index) == ' ') {
                insideWord = false;
            }
        }

        int[][] indexes = new int[wordCount][2];
        int wordIndex = 0;
        int start = -1;
        for (int index = 0; index <= textLength; index++) {
            char current = index < textLength ? text.charAt(index) : ' ';
            if (current != ' ' && start == -1) {
                start = index;
            } else if ((current == ' ' || index == textLength) && start != -1) {
                indexes[wordIndex][0] = start;
                indexes[wordIndex][1] = index;
                wordIndex++;
                start = -1;
            }
        }

        String[] words = new String[wordCount];
        for (int index = 0; index < wordCount; index++) {
            words[index] = createSubstring(text, indexes[index][0], indexes[index][1]);
        }
        return words;
    }

    public static String createSubstring(String text, int start, int end) {
        StringBuilder builder = new StringBuilder();
        for (int index = start; index < end; index++) {
            builder.append(text.charAt(index));
        }
        return builder.toString();
    }

    public static boolean compareStringArrays(String[] first, String[] second) {
        if (first.length != second.length) {
            return false;
        }
        for (int index = 0; index < first.length; index++) {
            if (!first[index].equals(second[index])) {
                return false;
            }
        }
        return true;
    }

    public static void displayWords(String title, String[] words) {
        System.out.println(title);
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] userDefinedWords = splitIntoWords(text);
        String[] builtInWords = text.trim().isEmpty() ? new String[0] : text.trim().split("\\s+");

        displayWords("Words using user-defined method:", userDefinedWords);
        displayWords("Words using built-in split():", builtInWords);
        System.out.println("Both arrays are equal: " + compareStringArrays(userDefinedWords, builtInWords));
        scanner.close();
    }
}
