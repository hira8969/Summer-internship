package numberprogram;

import java.util.Scanner;

public class six {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner (System.in);
		System.out.print("Enter a number: ");
		int num= sc.nextInt();
		int sum=0;
		while(num>0)
		{
			int last= num%10;
			sum += last;
			num= num/10;
		}
		System.out.println("Sum of NUmber:  " + sum);
		
	}

}
