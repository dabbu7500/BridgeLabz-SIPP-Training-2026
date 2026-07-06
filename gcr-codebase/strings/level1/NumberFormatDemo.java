import java.util.Scanner;

class NumberFormatDemo {

    public static void generateNumberFormatException(String text) {
        System.out.println("Parsing non-numeric string...");
        int number = Integer.parseInt(text);
        System.out.println("Number: " + number);
    }

    public static void handleNumberFormatException(String text) {
        try {
            System.out.println("Parsing non-numeric string...");
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.println("=== Generating NumberFormatException ===");

        try {
            generateNumberFormatException(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception came to main: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException came to main: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Handling NumberFormatException ===");
        handleNumberFormatException(text);

        System.out.println("Program finished.");
    }

}
