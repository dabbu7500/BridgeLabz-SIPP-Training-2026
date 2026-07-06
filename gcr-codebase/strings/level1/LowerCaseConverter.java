import java.util.Scanner;

class LowerCaseConverter {

    public static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result = result + ch;
        }
        return result;
    }

    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        String userDefinedLowerCase = convertToLowerCase(text);
        String builtInLowerCase = text.toLowerCase();

        boolean areEqual = compareStringsUsingCharAt(userDefinedLowerCase, builtInLowerCase);

        System.out.println("Lowercase using charAt(): " + userDefinedLowerCase);
        System.out.println("Lowercase using toLowerCase(): " + builtInLowerCase);
        System.out.println("Are both equal? " + areEqual);
    }

}
