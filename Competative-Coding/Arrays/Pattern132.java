package Arrays;

   
import java.util.Stack;

public class Pattern132 {
    public static boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < third) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(find132pattern(nums1)); // false

        int[] nums2 = {3, 1, 4, 2};
        System.out.println(find132pattern(nums2)); // true

        int[] nums3 = {-1, 3, 2, 0};
        System.out.println(find132pattern(nums3)); // true
    }
}