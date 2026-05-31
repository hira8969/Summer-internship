package arrays;

import java.util.Arrays;

public class twenty5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int[] arr = {23, 55, 57, 93, 10, 1};

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = singleDigitSum(arr[i]);
        }

        System.out.println(Arrays.toString(result));

	}
	static int singleDigitSum(int num) {
        while (num > 9) {
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }

    

}
