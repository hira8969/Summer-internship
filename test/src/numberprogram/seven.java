package numberprogram;

import java.util.Scanner;

public class seven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner (System.in);
		System.out.print("Enter a number: ");
		int num= sc.nextInt();
		int rev=0;
		while(num>0)
		{
			int last= num%10;
			rev = (rev *10)+ last;
			num= num/10;
		}
		System.out.println("Reverse number: "+ rev);
	}

}
