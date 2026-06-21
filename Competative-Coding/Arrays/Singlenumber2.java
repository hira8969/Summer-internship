package Arrays;
  
import java.util.Arrays;
public class Singlenumber2 {
    public static int[] singleNumber(int[] nums) {

        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        int rightMostBit = xor & (-xor);

        int first = 0;
        int second = 0;

        for (int num : nums) {

            if ((num & rightMostBit) == 0) {
                first ^= num;
            } else {
                second ^= num;
            }
        }

        return new int[]{first, second};
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] ans = singleNumber(nums);

        System.out.println(Arrays.toString(ans));
    }
}