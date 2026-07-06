import java.util.Scanner;

public class CharacterTypes {
    public static String checkCharacterType(char character) {
        if (character >= 'A' && character <= 'Z') {
            character = (char) (character + 32);
        }
        if (character < 'a' || character > 'z') {
            return "Not a Letter";
        }
        if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
            return "Vowel";
        }
        return "Consonant";
    }

    public static String[][] findCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int index = 0; index < text.length(); index++) {
            char character = text.charAt(index);
            result[index][0] = String.valueOf(character);
            result[index][1] = checkCharacterType(character);
        }
        return result;
    }

    public static void displayTable(String[][] result) {
        System.out.printf("%-12s %-15s%n", "Character", "Type");
        System.out.println("---------------------------");
        for (String[] row : result) {
            String character = row[0].equals(" ") ? "space" : row[0];
            System.out.printf("%-12s %-15s%n", character, row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[][] result = findCharacterTypes(text);
        displayTable(result);
        scanner.close();
    }
}
