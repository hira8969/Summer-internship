package numberprogram;

import java.util.Scanner;

public class second {
	public static void main(String [] s)
	{
		// positive or negative and Zero
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter number Here: ");
		int n= sc.nextInt();
		if(n<0) {
			System.out.println("Number is Negative ");
			
		}
		if(n>0)
		{
			System.out.println("Number is Positive ");
			
		}
		if(n==0) {
			System.out.println("Number is Zero ");
		}
	}
}
