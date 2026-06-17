import java.util.Scanner;
public class PrintNumbersFromNTo1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter value of n :");
        int n=sc.nextInt();
        print(n);

    }
    public static void print(int n)
    {
        if(n==0) return;
        System.out.print(n +" ");
        print(n-1);
    }
}