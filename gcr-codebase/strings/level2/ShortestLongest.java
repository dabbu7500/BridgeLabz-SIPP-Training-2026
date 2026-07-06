import java.util.Scanner;

public class ShortestLongest {
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

    public static int[] findShortestAndLongestIndexes(String[][] wordLengths) {
        if (wordLengths.length == 0) {
            return new int[] {-1, -1};
        }

        int shortestIndex = 0;
        int longestIndex = 0;
        for (int index = 1; index < wordLengths.length; index++) {
            int currentLength = Integer.parseInt(wordLengths[index][1]);
            if (currentLength < Integer.parseInt(wordLengths[shortestIndex][1])) {
                shortestIndex = index;
            }
            if (currentLength > Integer.parseInt(wordLengths[longestIndex][1])) {
                longestIndex = index;
            }
        }
        return new int[] {shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] wordLengths = createWordLengthArray(splitIntoWords(text));
        int[] result = findShortestAndLongestIndexes(wordLengths);

        if (result[0] == -1) {
            System.out.println("No words found.");
        } else {
            System.out.println("Shortest word: " + wordLengths[result[0]][0] + " (" + wordLengths[result[0]][1] + ")");
            System.out.println("Longest word: " + wordLengths[result[1]][0] + " (" + wordLengths[result[1]][1] + ")");
        }
        scanner.close();
    }
}
