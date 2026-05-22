package numberprogram;

import java.util.Scanner;

public class five {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// swap value without using third veriable 
		System.out.println("Enter First number: ");
		int a = sc.nextInt();

		System.out.println("Enter Second number: ");
		int b = sc.nextInt();
		System.out.println("Before Swaping Value: " + a + "  "+ b);
		a= a+b;
		b= a-b;
		a= a-b;
		System.out.println("after Swaping Value: " + a + "  "+ b);

	}

}
