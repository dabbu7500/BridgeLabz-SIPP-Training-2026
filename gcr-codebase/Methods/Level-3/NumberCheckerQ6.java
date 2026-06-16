public class NumberCheckerQ6 {
    public static void main(String[] args) {
        int number = 28;
        
        System.out.println("Is Perfect: " + isPerfect(number));
        System.out.println("Is Abundant: " + isAbundant(number));
        System.out.println("Is Deficient: " + isDeficient(number));
        System.out.println("Is Strong: " + isStrong(number));
    }

    private static int getProperDivisorSum(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) sum += i;
        }
        return sum;
    }

    public static boolean isPerfect(int number) {
        return getProperDivisorSum(number) == number;
    }

    public static boolean isAbundant(int number) {
        return getProperDivisorSum(number) > number;
    }

    public static boolean isDeficient(int number) {
        return getProperDivisorSum(number) < number;
    }

    public static boolean isStrong(int number) {
        int sum = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            sum += factorial(temp % 10);
            temp /= 10;
        }
        return sum == number;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}