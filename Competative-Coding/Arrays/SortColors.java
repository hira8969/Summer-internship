package Arrays;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            switch (nums[mid]) {

                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Before: " + Arrays.toString(nums));

        sortColors(nums);

        System.out.println("After : " + Arrays.toString(nums));
    }
}