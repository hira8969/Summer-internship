package numberprogram;

import java.util.Scanner;

public class first {
	public static void main(String []s)
	{
		// 
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number Here:");
		int n= sc.nextInt();
		if(n % 2== 0)
		{
			System.out.println(n + " is Even number ");
		}
		else {
			System.out.println("Number is Odd:- "+ n);
		}
	}
}
