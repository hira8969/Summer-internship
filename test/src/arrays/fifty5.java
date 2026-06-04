package arrays;

import java.util.Arrays;
// 55. Write a Java program to sort array elements using the sort() method.   
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