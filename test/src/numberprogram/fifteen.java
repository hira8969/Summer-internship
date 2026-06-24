package numberprogram;

import java.util.Scanner;

public class fifteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        perfect(num);
	}
	public static void perfect(int num)
	{
		int sum=0;
		
		for(int i=1;i<num;i++)
		{
			if(num%i == 0)
			{
				sum += i;
			}
		}
		if (sum == num)
		{
			System.out.println(num + " is a perfect number");
		}
		else {
			System.out.println(num + " is not a perfect number");
		}
	}

}
