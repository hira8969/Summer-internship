package numberprogram;

import java.util.Scanner;

public class third {

	public static void main(String[] a1) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter First number: ");
		int a = sc.nextInt();

		System.out.println("Enter Second number: ");
		int b = sc.nextInt();

		System.out.println("Enter Third number: ");
		int c = sc.nextInt();

		if (a > b && a > c) {

			System.out.println("The largest element is :- " + a);

		} 
		else if (b > a && b > c) {

			System.out.println("The largest element is :- " + b);

		} 
		else {

			System.out.println("The largest element is :- " + c);
		}

		sc.close();
	}
}