package CommonProblem;

import java.util.Scanner;


public class Reversenumber {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number Here: ");
        int n= sc.nextInt();
        System.out.println("Before reverse Number: "+ n);
        reverse(n);
    }
    static void reverse(int n)
    {
        int rev=0;
        while(n>0)
        {
            int last= n %10;
            rev= (rev *10) + last;
            n=n/10;

        }
        System.out.println("After Reverse NUmber : "+ rev);
    }
}
