import java.util.Scanner;

public class SumOfFirstNNaturalNumbers {
    public static void main(String[] args)
    {
         Scanner sc=new Scanner(System.in);
        System.out.print("enter value of n :");
        int n=sc.nextInt();
        
        System.out.print("sum : "+totalSum(n));
    }
    public static int totalSum(int n)
    {
        if(n==0)
            return 0;
        
        return n + totalSum(n-1);

    }
}
