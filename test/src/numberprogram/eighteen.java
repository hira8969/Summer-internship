package numberprogram;

import java.util.Scanner;

public class eighteen {
	public static void fibonacii(int n)
	{
		int first=0;
		int second=1;

		System.out.print("Fibonacii Series of "+ n +"  ");
		for(int i=1; i<=n;i++)
		{
			System.out.print(first + "   ");
			int temp = first+second;
			first= second;
			second = temp;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        fibonacii(num);
	}

}
