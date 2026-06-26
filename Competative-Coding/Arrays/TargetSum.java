package Arrays;

    
import java.util.*;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int num : nums)
            sum += num;

        if (Math.abs(target) > sum)
            return 0;

        if ((sum + target) % 2 != 0)
            return 0;

        int subset = (sum + target) / 2;

        int[] dp = new int[subset + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = subset; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[subset];
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

        System.out.println(findTargetSumWays(nums, target));

        sc.close();
    }
}