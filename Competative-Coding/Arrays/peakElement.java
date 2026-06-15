package Arrays ;

import java.util.*;
//162. Find Peak Element
public class PeakElement {

    public static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {

                right = mid;

            } else {

                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        int peakIndex = findPeakElement(nums);

        System.out.println("Peak Index = " + peakIndex);

        System.out.println("Peak Element = " + nums[peakIndex]);
    }
}