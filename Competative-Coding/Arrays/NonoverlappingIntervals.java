package Arrays;

    
import java.util.Arrays;
public class NonoverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {

        // Sort by ending time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int remove = 0;

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlap
            if (intervals[i][0] < prevEnd) {

                remove++;

            } else {

                prevEnd = intervals[i][1];
            }
        }

        return remove;
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        int ans = eraseOverlapIntervals(intervals);

        System.out.println("Minimum intervals to remove = " + ans);
    }
}