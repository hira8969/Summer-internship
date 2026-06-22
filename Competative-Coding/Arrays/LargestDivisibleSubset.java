package Arrays;
//368. Largest Divisible Subset 
import java.util.*;
public class LargestDivisibleSubset {


    public static List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0) {

                    if (dp[j] + 1 > dp[i]) {

                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }

            if (dp[i] > maxLen) {

                maxLen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (lastIndex != -1) {

            ans.add(nums[lastIndex]);

            lastIndex = prev[lastIndex];
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 8};

        System.out.println(largestDivisibleSubset(nums));
    }
}