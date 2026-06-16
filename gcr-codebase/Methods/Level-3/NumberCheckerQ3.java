public class NumberCheckerQ3 {
    public static void main(String[] args) {
        int number = 212;
        int[] digits = getDigitsArray(number);

        System.out.println("Count of digits: " + getDigitCount(number));
        System.out.println("Sum of digits: " + getSum(digits));
        System.out.println("Sum of squares of digits: " + getSumOfSquares(digits));
        System.out.println("Is Harshad Number: " + isHarshad(number, digits));
        
        int[][] freq = getDigitFrequency(digits);
        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (freq[i][1] > 0) {
                System.out.println("Digit " + freq[i][0] + ": " + freq[i][1] + " times");
            }
        }
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

    public static int getSum(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += d;
        return sum;
    }

    public static int getSumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int number, int[] digits) {
        return number % getSum(digits) == 0;
    }

    public static int[][] getDigitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int d : digits) freq[d][1]++;
        return freq;
    }
}