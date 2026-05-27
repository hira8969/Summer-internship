package arrays;

public class twenty3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 2, 1, 3, 0, 4};
		 secondSmall(arr);
	        
	}
	public static void secondSmall(int arr[])
	{
		int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {

            // Find smallest element
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            }

            // Find second smallest element
            else if (num > smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }

        System.out.println("Second Smallest Element = " + secondSmallest);
	}

}
