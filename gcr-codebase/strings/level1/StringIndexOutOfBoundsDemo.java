import java.util.Scanner;

class StringIndexOutOfBoundsDemo {

    public static void generateStringIndexOutOfBoundsException(String text) {
        System.out.println("Accessing char at index beyond length...");
        char ch = text.charAt(text.length());
        System.out.println("Character: " + ch);
    }

    public static void handleStringIndexOutOfBoundsException(String text) {
        try {
            System.out.println("Accessing char at index beyond length...");
            char ch = text.charAt(text.length());
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.println("=== Generating StringIndexOutOfBoundsException ===");

        try {
            generateStringIndexOutOfBoundsException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception came to main: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Handling StringIndexOutOfBoundsException ===");
        handleStringIndexOutOfBoundsException(text);

        System.out.println("Program finished.");
    }

}
