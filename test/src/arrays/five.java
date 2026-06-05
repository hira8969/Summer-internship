package arrays;
//Write a Java program to print odd elements present in an array. 
public class five {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5,6};
		int n= arr.length;
		for(int i=0;i<n;i++)
		{
			if(arr[i] %2 !=0)   // oddd  value 
			{
				System.out.print(arr[i] + "  ");
			}
		}
		System.out.println(" -------odddddd");
	}

}
