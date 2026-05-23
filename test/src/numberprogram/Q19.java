package numberprogram;

import java.util.Scanner;

public class Q19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        factorial(num);
	}
	public static void factorial(int n)
	{
		int fact=1;
		for(int i=1;i<=n;i++)
		{
			fact *=i;
		}
		System.out.println("Factorail is : "+ fact);
	}

}
