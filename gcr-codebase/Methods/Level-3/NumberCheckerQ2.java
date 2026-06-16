public class NumberCheckerQ2 {
    public static void main(String[] args) {
        int number = 153;
        int[] digits = getDigitsArray(number);
        
        System.out.println("Digit Count: " + getDigitCount(number));
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(number, digits));
        findLargestAndSecondLargest(digits);
        findSmallestAndSecondSmallest(digits);
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

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, digits.length);
        return sum == number;
    }

    public static void findLargestAndSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        System.out.println("Largest: " + largest + ", 2nd Largest: " + secondLargest);
    }

    public static void findSmallestAndSecondSmallest(int[] arr) {
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }
        System.out.println("Smallest: " + smallest + ", 2nd Smallest: " + secondSmallest);
    }
}