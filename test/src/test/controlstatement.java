package test;

import java.util.Scanner;

public class controlstatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=20;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your choice: ");
		int choice= sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("User Choose 1: ");
				break;
			case 2:
				System.out.println("User Choose 2: ");
				break;
			default: 
				System.out.println("Your Cases are not match plese enter 1-2 ");
		
		}
	}

}
