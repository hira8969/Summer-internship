package arrays;

public class twenty7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 1, 3, 2, 4};
		removeduplicate(arr);

    }
	public static void removeduplicate(int arr[])
	{
		for (int i = 0; i < arr.length; i++) {
            boolean duplicate = false;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                System.out.print(arr[i] + " ");
            }
        }

	}

}
