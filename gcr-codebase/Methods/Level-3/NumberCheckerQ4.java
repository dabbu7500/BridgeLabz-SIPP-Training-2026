import java.util.Arrays;

public class NumberCheckerQ4 {
    public static void main(String[] args) {
        int number = 121;
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseArray(digits);

        System.out.println("Count of digits: " + getDigitCount(number));
        System.out.println("Are arrays equal: " + compareArrays(digits, reversed));
        System.out.println("Is Palindrome: " + isPalindrome(digits, reversed));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
    }

    public static int getDigitCount(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] getDigitsArray(int number) {
        int count = getDigitCount(number);
        int[] digits = new int[count];
        int temp = Math.abs(number);
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static boolean isPalindrome(int[] digits, int[] reversed) {
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }
}