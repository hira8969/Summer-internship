package Arrays;

//480. Sliding Window Median  
import java.util.*;

public class SlidingWindowMedian {
    static class SlidingMedian {

        PriorityQueue<Long> small = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> large = new PriorityQueue<>();
        HashMap<Long, Integer> delayed = new HashMap<>();

        int smallSize = 0;
        int largeSize = 0;

        public double[] medianSlidingWindow(int[] nums, int k) {

            int n = nums.length;
            double[] ans = new double[n - k + 1];

            for (int i = 0; i < k; i++)
                add(nums[i]);

            ans[0] = getMedian(k);

            for (int i = k; i < n; i++) {
                add(nums[i]);
                remove(nums[i - k]);
                ans[i - k + 1] = getMedian(k);
            }

            return ans;
        }

        void add(long num) {
            if (small.isEmpty() || num <= small.peek()) {
                small.offer(num);
                smallSize++;
            } else {
                large.offer(num);
                largeSize++;
            }
            balance();
        }

        void remove(long num) {
            delayed.put(num, delayed.getOrDefault(num, 0) + 1);

            if (num <= small.peek()) {
                smallSize--;
                if (num == small.peek())
                    prune(small);
            } else {
                largeSize--;
                if (!large.isEmpty() && num == large.peek())
                    prune(large);
            }

            balance();
        }

        void balance() {
            if (smallSize > largeSize + 1) {
                large.offer(small.poll());
                smallSize--;
                largeSize++;
                prune(small);
            } else if (smallSize < largeSize) {
                small.offer(large.poll());
                smallSize++;
                largeSize--;
                prune(large);
            }
        }

        void prune(PriorityQueue<Long> heap) {
            while (!heap.isEmpty()) {
                long num = heap.peek();

                if (delayed.containsKey(num)) {
                    delayed.put(num, delayed.get(num) - 1);

                    if (delayed.get(num) == 0)
                        delayed.remove(num);

                    heap.poll();
                } else {
                    break;
                }
            }
        }

        double getMedian(int k) {
            if ((k & 1) == 1)
                return (double) small.peek();

            return ((double) small.peek() + (double) large.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int k = sc.nextInt();

        SlidingMedian obj = new SlidingMedian();

        double[] ans = obj.medianSlidingWindow(nums, k);

        for (double x : ans)
            System.out.printf("%.5f ", x);

        sc.close();
    }
}