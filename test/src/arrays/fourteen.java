package arrays;

import java.util.Scanner;

public class fourteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter size of array: ");
	        int size = sc.nextInt();

	        int[] arr = new int[size];

	        System.out.println("Enter even values:");

	        for (int i = 0; i < size; i++) {

	            int value = sc.nextInt();

	            if (value % 2 == 0) {
	                arr[i] = value;
	            } else {
	                System.out.println("Odd number not allowed. Storing 0 instead.");
	                arr[i] = 0;
	            }
	        }

	        System.out.println("Array elements are:");

	        for (int i = 0; i < size; i++) {
	            System.out.print(arr[i] + " ");
	        }
	}

}
