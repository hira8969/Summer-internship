package arrays;

public class thirteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 0, 5, 0, 7, 0, 9, 2, 0};
		countZero(arr);
        
	}
	public static void countZero(int arr[])
	{
		int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                count++;
            }
        }

        System.out.println("Number of zeros in array: " + count);
	}

}
