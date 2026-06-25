package Arrays;

import java.util.Arrays;
//321. Create Maximum Number

public class CreateMaximumNumber {

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[k];

        int start = Math.max(0, k - n);
        int end = Math.min(k, m);

        for (int i = start; i <= end; i++) {
            int[] a = maxArray(nums1, i);
            int[] b = maxArray(nums2, k - i);
            int[] candidate = merge(a, b, k);

            if (greater(candidate, 0, ans, 0))
                ans = candidate;
        }

        return ans;
    }

    private static int[] maxArray(int[] nums, int k) {
        int[] stack = new int[k];
        int top = -1;
        int remain = nums.length;

        for (int num : nums) {
            while (top >= 0 && stack[top] < num && remain > k - top - 1)
                top--;

            if (top + 1 < k)
                stack[++top] = num;

            remain--;
        }

        return stack;
    }

    private static int[] merge(int[] a, int[] b, int k) {
        int[] res = new int[k];
        int i = 0, j = 0;

        for (int r = 0; r < k; r++) {
            if (greater(a, i, b, j))
                res[r] = a[i++];
            else
                res[r] = b[j++];
        }

        return res;
    }

    private static boolean greater(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }

        if (j == b.length) return true;
        if (i == a.length) return false;

        return a[i] > b[j];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;

        int[] ans = maxNumber(nums1, nums2, k);

        System.out.println(Arrays.toString(ans));
        // Output: [9, 8, 6, 5, 3]
    }
}