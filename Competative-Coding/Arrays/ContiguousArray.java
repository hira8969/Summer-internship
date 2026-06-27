package Arrays;

//525. Contiguous Array
import java.util.*;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1, 1, 0};

        System.out.println(findMaxLength(nums));
    }
}