package arrays;

public class eight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {1,2,3,4,5,6};
		int n= arr.length;
		int sum=0; // even value SUm 
		for(int i=0;i<n;i++)
		{
			if(arr[i] %2==0)
			{
				sum += arr[i];
			}
		}
		System.out.println("Sum of Even Value:-  " + sum);
	}

}
