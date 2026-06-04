package arrays;

import java.util.Arrays;

public class fifty5 {

    public static void main(String[] args) {

        int[] arr = {9, 5, 6, 1, 2, 7};

        Arrays.sort(arr);

        System.out.print("Output: ");

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}