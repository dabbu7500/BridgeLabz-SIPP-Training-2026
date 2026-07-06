import java.util.Scanner;

class CharacterFrequencyNestedLoops {
    public static String[] findCharacterFrequencies(String text) {
        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];
        int uniqueCount = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '\0') {
                continue;
            }

            frequency[i] = 1;
            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '\0';
                }
            }
            uniqueCount++;
        }

        String[] result = new String[uniqueCount];
        int index = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != '\0') {
                result[index] = characters[i] + " : " + frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void displayFrequencies(String[] frequencies) {
        System.out.println("Character frequencies:");
        for (String frequency : frequencies) {
            System.out.println(frequency);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        String[] frequencies = findCharacterFrequencies(text);
        displayFrequencies(frequencies);
    }
}
