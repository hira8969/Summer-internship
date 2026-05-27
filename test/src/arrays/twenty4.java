package arrays;

public class twenty4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0, 2, -1, 0, 2, -1, 3};

        ZeroOne(arr);
       
	}
	public static void ZeroOne(int arr[])
	{
		 for (int i = 0; i < arr.length; i++) {

	            if (arr[i] == 0) {
	                arr[i] = -1;
	            }

	            else if (arr[i] == -1) {
	                arr[i] = 0;
	            }
	        }

	        // Print updated array
	        System.out.print("Output: {");

	        for (int i = 0; i < arr.length; i++) {

	            System.out.print(arr[i]);

	            if (i != arr.length - 1) {
	                System.out.print(", ");
	            }
	        }

	        System.out.println("}");
	}

}
