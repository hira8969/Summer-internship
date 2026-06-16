package numberprogram;

import java.util.Scanner;

public class ten {
	public static int power(int num, int digit)
	{
		int pow= 1;
		for(int i=1;i<=digit; i++)
		{
			pow *= num;
		}
		return pow;
	}
	public static void armstrong(int num)
	{
		int count=0;
		int sum=0;
		int real=num;
		while(num>0)
		{
			count ++;
			num= num/10;
		}
		int t= real;
		while(t>0)
		{
			int last= t% 10;
			sum += power(last , count);
			t= t/10;
		}
		if (sum == real)
		{
			System.out.println(real+ " is Armstrong Number: ");
		}
		else {
			System.out.println(real+ " is Not Armstrong Number: ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a nuumber: ");
		int num= sc.nextInt();
		armstrong(num);
		
	}

}
