public class NumberCheckerQ5 {
    public static void main(String[] args) {
        int number = 7;
        
        System.out.println("Is Prime: " + isPrime(number));
        System.out.println("Is Neon: " + isNeon(number));
        System.out.println("Is Spy: " + isSpy(number));
        System.out.println("Is Automorphic: " + isAutomorphic(number));
        System.out.println("Is Buzz: " + isBuzz(number));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    public static boolean isSpy(int number) {
        int sum = 0, product = 1;
        int temp = Math.abs(number);
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        long square = (long) number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    public static boolean isBuzz(int number) {
        return (number % 7 == 0) || (number % 10 == 7);
    }
}