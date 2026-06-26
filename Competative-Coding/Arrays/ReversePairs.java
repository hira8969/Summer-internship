package Arrays;
//493. Reverse Pairs 
import java.util.*;

public class ReversePairs {
    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {

        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;

        int count = mergeSort(nums, left, mid)
                  + mergeSort(nums, mid + 1, right);

        int j = mid + 1;

        // Count reverse pairs
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j])
                j++;
            count += j - (mid + 1);
        }

        // Merge two sorted halves
        int[] temp = new int[right - left + 1];

        int i = left;
        j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }

        while (i <= mid)
            temp[k++] = nums[i++];

        while (j <= right)
            temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, left, temp.length);

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input:
        // First line: n
        // Second line: n integers

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(reversePairs(nums));

        sc.close();
    }
}