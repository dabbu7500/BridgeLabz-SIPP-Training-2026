import java.util.Scanner;

class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingCharacter(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (frequency[current] == 1) {
                return current;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeatingCharacter(text);
        if (result == '\0') {
            System.out.println("There is no non-repeating character.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }
    }
}
