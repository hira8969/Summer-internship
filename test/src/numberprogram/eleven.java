package numberprogram;

import java.util.Scanner;

public class eleven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc= new Scanner(System.in);
		
			System.out.println("Enter number Here: ");
			int n= sc.nextInt();
			checkneon(n);
			
	}
	public static void checkneon(int n)
	{
		int sn= n*n;
		int temp=n;
		int sumofsn=0;
		while(sn>0)
		{
			int last= sn% 10;
			sumofsn += last;
			sn=sn/10;
		}
		if (temp== sumofsn)
		{
			System.out.println(temp + " is a neon number");
		}
		else {
			System.out.println(temp + " is not a neon number");
		}
	}

}
