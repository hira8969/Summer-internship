package numberprogram;

import java.util.Scanner;

public class fourteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int temp=num;
        int sum=0;
        while(temp> 0)
        {
        	int digit= temp %10;
        	sum += factorial(digit);
        	temp /= 10;
        }
        if(num == sum)
        {
        	System.out.println(num +" is a strong number");
        }
        else {
        	System.out.println(num +" is not a strong number");
        }
	}
	public static int factorial(int num)
	{
		int fact=1;
		for(int i=1;i<=num;i++)
		{
			fact *= i;
		}
		return fact;
	}

}
