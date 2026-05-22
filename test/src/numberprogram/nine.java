package numberprogram;

import java.util.Scanner;

public class nine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a nuumber: ");
		int num= sc.nextInt();
		int count= 0;
		while(num >0)
		{
			count ++;
			num= num/10;
		}
		System.out.println("Count is : "+ count);
	}

}
