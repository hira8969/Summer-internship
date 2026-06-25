package Arrays;
import java.util.Scanner;
//3737. Count Subarrays With Majority Element I
public class CountSubarrWithmejorityele {
    
    public static int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int countTarget = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    countTarget++;
                }

                int len = j - i + 1;

                if (2 * countTarget > len) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        int n = sc.nextInt();

        // Input array elements
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target
        int target = sc.nextInt();

        // Output result
        System.out.println(countMajoritySubarrays(nums, target));

        sc.close();
    }
}