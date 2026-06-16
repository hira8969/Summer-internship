package numberprogram;

import java.util.Scanner;

public class fourth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// swap value using third veriable 
		System.out.println("Enter First number: ");
		int a = sc.nextInt();

		System.out.println("Enter Second number: ");
		int b = sc.nextInt();
		System.out.println("Before Swaping Value: " + a + "  "+ b);

		int temp ;
		temp=a;
		a=b;
		b=temp;
		System.out.println("After Swaping Value: " + a + "  "+ b);
	}

}
