package arrays;

import java.util.Scanner;

public class nineteen {

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
		
		squire(arr,n);
	}
	public static void squire(int arr[] , int n)
	{
		System.out.print("Squire of elements : "+ "  ");
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]* arr[i] +"   ");
		}
	}

}
