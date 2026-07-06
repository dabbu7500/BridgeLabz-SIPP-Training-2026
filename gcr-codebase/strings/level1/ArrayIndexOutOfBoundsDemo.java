import java.util.Scanner;

class ArrayIndexOutOfBoundsDemo {

    public static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println("Accessing index beyond array length...");
        String name = names[names.length];
        System.out.println("Name: " + name);
    }

    public static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println("Accessing index beyond array length...");
            String name = names[names.length];
            System.out.println("Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many names: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }

        System.out.println("=== Generating ArrayIndexOutOfBoundsException ===");

        try {
            generateArrayIndexOutOfBoundsException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception came to main: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RuntimeException came to main: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Handling ArrayIndexOutOfBoundsException ===");
        handleArrayIndexOutOfBoundsException(names);

        System.out.println("Program finished.");
    }

}
