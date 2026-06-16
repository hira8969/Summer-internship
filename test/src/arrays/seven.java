package arrays;
//Write a Java program to print even index values sum and odd index values sum. 
public class seven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6};
		int n= arr.length;
		int Esum=0;
		int Osum=0;
		for(int i=0;i<n;i++)
		{
			if(i %2 ==0)   // even index value 
			{
				Esum += arr[i];
			}
			else {
				Osum += arr[i];
			}
		}
		System.out.println("Sum of Even Index:-  " + Esum);
		System.out.println("Sum of Odd Index:-  " + Osum);
	}

}
