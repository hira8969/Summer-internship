package arrays;

public class second {
	public static void main(String []a)
	{
		int arr[]= {1,2,3,4,5,6};
		int n= arr.length;
		for(int i=0;i<n;i++)
		{
			if(i %2 ==0)   // even index value 
			{
				System.out.print(arr[i] + "  ");
			}
		}
		System.out.println(" end");
	}

}
