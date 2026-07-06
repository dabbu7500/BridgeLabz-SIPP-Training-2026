import java.util.Scanner;

class AnagramChecker {
    public static boolean areAnagrams(String firstText, String secondText) {
        if (firstText.length() != secondText.length()) {
            return false;
        }

        int[] firstFrequency = new int[256];
        int[] secondFrequency = new int[256];

        for (int i = 0; i < firstText.length(); i++) {
            firstFrequency[firstText.charAt(i)]++;
            secondFrequency[secondText.charAt(i)]++;
        }

        for (int i = 0; i < firstFrequency.length; i++) {
            if (firstFrequency[i] != secondFrequency[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first text: ");
        String firstText = scanner.nextLine();
        System.out.print("Enter second text: ");
        String secondText = scanner.nextLine();

        if (areAnagrams(firstText, secondText)) {
            System.out.println("The two texts are anagrams.");
        } else {
            System.out.println("The two texts are not anagrams.");
        }
    }
}
