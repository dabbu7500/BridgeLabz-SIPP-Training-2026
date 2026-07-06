class NullPointerDemo {

    public static void generateNullPointerException() {
        String text = null;

        System.out.println("Calling length() on null reference...");
        int length = text.length();
        System.out.println("Length: " + length);
    }

    public static void handleNullPointerException() {
        String text = null;

        try {
            System.out.println("Calling length() on null reference...");
            int length = text.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Generating NullPointerException ===");

        try {
            generateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Exception came to main: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Handling NullPointerException ===");
        handleNullPointerException();

        System.out.println("Program finished.");
    }

}
