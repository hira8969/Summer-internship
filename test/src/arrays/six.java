package arrays;

public class six {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// sum of all index 
		int arr[]= {1,2,3,4,5,6};
		int n= arr.length;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum += arr[i];
		}
		System.out.println(" Sum of all elements:- " + sum);
	}

}
