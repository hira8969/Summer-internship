package arrays;
// write a java program to store characters in an array and print them in reverse order.
public class first {

	public static void main(String[] args) {
		
		String []arr= {"Hira","Lal","Kumar","Raja","Arjun","Prashant"};
		int n= arr.length ;
		for(int i= n-1; i>0 ;i--)
		{
			System.out.print(arr[i] + "  ");
		}
		System.out.println("End !!!!");
	}

}
