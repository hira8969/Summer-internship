package CommonProblem;

import java.util.Scanner;

public class sumofdigit {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number here: ");
        int num= sc.nextInt();
        sumofdigit1(num);
    }
    public static void sumofdigit1(int n)
    {
        int sum=0;
        while(n>0)
        {
            int last= n%10;
            sum = (sum+ last) ;
            n=n/10;
        }
        System.out.println("sum of digit: "+ sum);
    }
}
