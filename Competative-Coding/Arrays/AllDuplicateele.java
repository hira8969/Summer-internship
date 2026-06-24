package Arrays;


    
import java.util.*;

public class AllDuplicateele {
    public static List<Integer> findDuplicates(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {

                ans.add(Math.abs(nums[i]));

            } else {

                nums[index] = -nums[index];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        System.out.println(findDuplicates(nums));
    }
}