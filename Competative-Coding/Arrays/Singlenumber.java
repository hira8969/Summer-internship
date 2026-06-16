package Arrays;
//137. Single Number II
public class SingleNumber {

    public static int singleNumber(int[] nums) {

        int ones = 0;
        int twos = 0;

        for (int num : nums) {

            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 2, 3, 2};
        System.out.println("Single Number: " + singleNumber(nums1));

        int[] nums2 = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Single Number: " + singleNumber(nums2));
    }
}