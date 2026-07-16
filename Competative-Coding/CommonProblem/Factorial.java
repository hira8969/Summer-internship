package CommonProblem;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number Here: ");
        int n=sc.nextInt();
        System.out.println("Factorial of a number is: "+ fact(n));
    }
    public static long fact(int n)
    {
        int fac=0;
        while(n>0)
        {
            int last = n%10;
            fac= (fac*10) + last;
            n=n/10;
        }
        return fac;
    }
}
