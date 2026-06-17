import java.util.Scanner;
public class CalculateFactorial {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter value of n :");
        int n=sc.nextInt();
        System.out.print(factorial(5));
    }
    public static int factorial(int n)
    {
        if(n==1)
            return 1;

        return n*factorial(n-1);
    }
}
