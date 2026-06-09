package Arrays;

import java.util.*;
//16. 3Sum Closest
public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int currentSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - currentSum) <
                    Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }

                if (currentSum == target)
                    return currentSum;

                if (currentSum < target)
                    left++;
                else
                    right--;
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Closest Sum = " +
                threeSumClosest(nums, target));

        sc.close();
    }
}