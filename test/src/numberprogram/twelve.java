package numberprogram;

import java.util.Scanner;

public class twelve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        spy(num);
	}
	public static void spy(int num)
	{
		int temp=num;
		int sum=0;
		int product=1;
		while(temp>0)
		{
			int last= temp%10;
			sum += last;
			product *=last;
			temp /=10;
		}
		if(sum==product)
		{
			System.out.println(num + " is a spy number");
		}
		else {
			System.out.println(num + " is not a spy number");
		}
	}

}
