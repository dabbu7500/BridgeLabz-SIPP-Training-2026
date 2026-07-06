import java.util.Scanner;

class IllegalArgumentExceptionDemo {

    public static void generateIllegalArgumentException(String text) {
        System.out.println("Doing substring with start > end...");
        String result = text.substring(5, 2);
        System.out.println("Result: " + result);
    }

    public static void handleIllegalArgumentException(String text) {
        try {
            System.out.println("Doing substring with start > end...");
            String result = text.substring(5, 2);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.println("=== Generating IllegalArgumentException ===");

        try {
            generateIllegalArgumentException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception came to main: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException came to main: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Handling IllegalArgumentException ===");
        handleIllegalArgumentException(text);

        System.out.println("Program finished.");
    }

}
