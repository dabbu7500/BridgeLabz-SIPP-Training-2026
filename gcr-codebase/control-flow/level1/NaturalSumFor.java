import java.util.Scanner;

public class NaturalSumFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 1) {
            int formulaSum = n * (n + 1) / 2;

            int loopSum = 0;

            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            System.out.println("Formula Sum = " + formulaSum);
            System.out.println("Loop Sum = " + loopSum);
            System.out.println("Both are equal: " + (formulaSum == loopSum));
        } else {
            System.out.println("Not a natural number");
        }
    }
}