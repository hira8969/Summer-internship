package CommonProblem;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        int x= fibo(n);
        System.out.println(x);
    }
    public static int fibo(int n)
    {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int first = 0;
        int second = 1;

        for (int i = 2; i <= n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }
        return second;

    }
}
