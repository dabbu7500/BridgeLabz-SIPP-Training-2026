import java.util.Scanner;

class CharacterFrequencyUsingAscii {
    public static String[][] findCharacterFrequencies(String text) {
        int[] frequency = new int[256];
        boolean[] added = new boolean[256];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (frequency[current] == 0) {
                uniqueCount++;
            }
            frequency[current]++;
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (!added[current]) {
                result[index][0] = String.valueOf(current);
                result[index][1] = String.valueOf(frequency[current]);
                added[current] = true;
                index++;
            }
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
