package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class twenty2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter arrys size: ");
		int n= sc.nextInt();
		int arr[]= new int [n];
		System.out.print("Enter arrys element: ");
		for(int i=0;i<n; i++)
		{
			
			arr[i]= sc.nextInt();
		}
		secondLargest(arr,n);
	}
	public static void secondLargest(int arr[], int n)
	{
		Arrays.sort(arr);
		System.out.println("Second Largest element is : "+ arr[n-2]);
	}

}
