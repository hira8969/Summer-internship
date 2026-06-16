package numberprogram;

import java.util.Scanner;

public class eight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a nuumber: ");
		int num= sc.nextInt();
		int rev=0;
		int real= num;
		while(num>0)
		{
			int last= num% 10;
			rev= (rev*10) + last;
			num= num/10;
		}
		if(real==rev)
		{
			System.out.println(real + "Is Palindrome Number: ");
		}
		else{
			System.out.println( real +" is Not Palindrome NUMber ");
		}
	}

}
