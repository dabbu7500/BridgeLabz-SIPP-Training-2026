import java.util.Scanner;

class UpperCaseConverter {

    public static String convertToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
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

        String userDefinedUpperCase = convertToUpperCase(text);
        String builtInUpperCase = text.toUpperCase();

        boolean areEqual = compareStringsUsingCharAt(userDefinedUpperCase, builtInUpperCase);

        System.out.println("Uppercase using charAt(): " + userDefinedUpperCase);
        System.out.println("Uppercase using toUpperCase(): " + builtInUpperCase);
        System.out.println("Are both equal? " + areEqual);
    }

}
