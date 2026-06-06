package arrays;
//write a java program to
import java.util.Scanner;

public class twenty {

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
		int max=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i] > max)
			{
				max= arr[i];
			}
		}
		System.out.println("Largest element is : "+ max);
	}

}
