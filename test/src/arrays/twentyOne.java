package arrays;

import java.util.Scanner;

public class twentyOne {

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
		largest(arr,n);
	}
	public static void largest(int arr[] , int n)
	{
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			if(arr[i] < min)
			{
				min= arr[i];
			}
		}
		System.out.println("Largest element is : "+ min);
	}
	

}
