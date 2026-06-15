import java.util.Scanner;

public class NumberChecker {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2)
            return 1;
        else if (num1 == num2)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("\nResult:");

        for (int num : numbers) {

            if (isPositive(num)) {

                if (isEven(num))
                    System.out.println(num + " is Positive and Even");
                else
                    System.out.println(num + " is Positive and Odd");

            } else {
                System.out.println(num + " is Negative");
            }
        }

        int result = compare(numbers[0], numbers[4]);

        System.out.println("\nComparison of First and Last Element:");

        if (result == 1)
            System.out.println("First element is Greater");
        else if (result == 0)
            System.out.println("Both elements are Equal");
        else
            System.out.println("First element is Less");
    }
}