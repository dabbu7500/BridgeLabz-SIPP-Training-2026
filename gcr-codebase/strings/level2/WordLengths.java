import java.util.Scanner;

public class WordLengths {
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

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index <= textLength; index++) {
            char current = index < textLength ? text.charAt(index) : ' ';
            if (current != ' ') {
                builder.append(current);
            } else if (builder.length() > 0) {
                words[wordIndex] = builder.toString();
                wordIndex++;
                builder.setLength(0);
            }
        }
        return words;
    }

    public static String[][] createWordLengthArray(String[] words) {
        String[][] wordLengths = new String[words.length][2];
        for (int index = 0; index < words.length; index++) {
            wordLengths[index][0] = words[index];
            wordLengths[index][1] = String.valueOf(findLengthWithoutLength(words[index]));
        }
        return wordLengths;
    }

    public static void displayTable(String[][] wordLengths) {
        System.out.printf("%-20s %10s%n", "Word", "Length");
        System.out.println("-------------------------------");
        for (String[] row : wordLengths) {
            System.out.printf("%-20s %10d%n", row[0], Integer.parseInt(row[1]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = splitIntoWords(text);
        String[][] wordLengths = createWordLengthArray(words);
        displayTable(wordLengths);
        scanner.close();
    }
}
