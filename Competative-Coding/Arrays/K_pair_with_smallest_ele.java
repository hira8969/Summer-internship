package Arrays;
   
import java.util.*;
public class K_pair_with_smallest_ele {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ans;
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < Math.min(nums1.length, k); i++) {

            pq.offer(new int[]{
                    nums1[i] + nums2[0],
                    i,
                    0
            });
        }

        while (k > 0 && !pq.isEmpty()) {

            int[] curr = pq.poll();

            int i = curr[1];
            int j = curr[2];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            k--;

            if (j + 1 < nums2.length) {

                pq.offer(new int[]{
                        nums1[i] + nums2[j + 1],
                        i,
                        j + 1
                });
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};

        int k = 3;

        System.out.println(kSmallestPairs(nums1, nums2, k));
    }
}