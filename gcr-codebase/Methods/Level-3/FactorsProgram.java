public class FactorsProgram {
    public static void main(String[] args) {
        int number = 12;
        int[] factors = getFactors(number);
        
        System.out.println("Greatest Factor: " + getGreatestFactor(factors));
        System.out.println("Sum of Factors: " + getSum(factors));
        System.out.println("Product of Factors: " + getProduct(factors));
        System.out.println("Product of Cubes: " + getProductOfCubes(factors));
    }

    public static int[] getFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int getGreatestFactor(int[] factors) {
        return factors[factors.length - 1];
    }

    public static int getSum(int[] factors) {
        int sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static int getProduct(int[] factors) {
        int product = 1;
        for (int f : factors) product *= f;
        return product;
    }

    public static double getProductOfCubes(int[] factors) {
        double product = 1;
        for (int f : factors) product *= Math.pow(f, 3);
        return product;
    }
}