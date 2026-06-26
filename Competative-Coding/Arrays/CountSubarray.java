package Arrays;
  //3739. Count Subarrays With Majority Element II  
import java.util.*;

public class CountSubarray {
    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public static long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        // Prefix sums range from -n to n
        int offset = n + 2;
        Fenwick ft = new Fenwick(2 * n + 5);

        long ans = 0;
        int prefix = 0;

        // Initial prefix sum = 0
        ft.update(offset, 1);

        for (int num : nums) {
            if (num == target)
                prefix++;
            else
                prefix--;

            int idx = prefix + offset;

            // Count previous prefix sums smaller than current
            ans += ft.query(idx - 1);

            ft.update(idx, 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input:
        // First line: n
        // Second line: n integers
        // Third line: target

        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        System.out.println(countMajoritySubarrays(nums, target));

        sc.close();
    }
}