package arrays;

public class eighteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 2, 1, 3, 3, 4};

        int minCount = arr.length;
        int minElement = arr[0];

        for (int i = 0; i < arr.length; i++) {

            int count = 0;

            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count < minCount) {
                minCount = count;
                minElement = arr[i];
            }
        }

        System.out.println("Minimum occurring element: " + minElement);
        System.out.println("Occurrence count: " + minCount);

	}

}
