package CommonProblem;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        fibo(n);
    }
    public static void fibo(int n)
    {
        int first=0;
        int second=1;
        int next;
        for(int i=1;i<=n;i++)
        {
            next= first + second;
            first= second;
            second= next;
        }
        System.out.println("fibonacci number is : "+ next);
    }
}
