package numberprogram;

import java.util.Scanner;

public class sixteen {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        primecheck(num);
	}
	public static void primecheck(int num)
	{
		boolean isprime=true;
		if(num <= 0) {
			isprime=false;
		}
		for(int i=2; i<= num/2;i++)
		{
			if(num % i==0)
			{
				isprime= false;
				break;
			}
		}
		if(isprime)
		{
			System.out.println(num +" is prime number");
		}
		else {
			System.out.println(num + " is not a prime number");
		}
	}

}
