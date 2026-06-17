import java.util.Scanner;
public class ReverseString {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string : ");
        String s=sc.next();
        reverse(s,s.length()-1);
    }
    public static void reverse(String s,int i){
        if(i<0) return;
        System.out.print(""+s.charAt(i));
        reverse(s,i-1);
    }
    
}
