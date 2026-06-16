package arrays;


public class twenty6 {
	static void removeduplicate(int arr[])
	{
		System.out.print("Output: {");

        boolean first = true;

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count == 1) {
                if (!first) {
                    System.out.print(",");
                }
                System.out.print(arr[i]);
                first = false;
            }
        }

        System.out.println("}");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 1, 3, 2, 4};
		removeduplicate(arr);

       }

}
