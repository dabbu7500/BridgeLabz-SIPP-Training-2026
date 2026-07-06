import java.util.Scanner;

class CharacterFrequencyUsingUnique {
    public static char[] findUniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        char[] uniqueCharacters = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueCharacters[i] = temp[i];
        }
        return uniqueCharacters;
    }

    public static String[][] findCharacterFrequencies(String text) {
        int[] frequency = new int[256];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        char[] uniqueCharacters = findUniqueCharacters(text);
        String[][] result = new String[uniqueCharacters.length][2];
        for (int i = 0; i < uniqueCharacters.length; i++) {
            result[i][0] = String.valueOf(uniqueCharacters[i]);
            result[i][1] = String.valueOf(frequency[uniqueCharacters[i]]);
        }

        return result;
    }

    public static void displayFrequencies(String[][] frequencies) {
        System.out.printf("%-12s %-10s%n", "Character", "Frequency");
        System.out.println("----------------------");
        for (String[] row : frequencies) {
            System.out.printf("%-12s %-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        String[][] frequencies = findCharacterFrequencies(text);
        displayFrequencies(frequencies);
    }
}
