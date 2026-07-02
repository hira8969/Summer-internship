package Arrays;
//630. Course Schedule III
    
import java.util.*;

public class CourseScheduleIII {
    public static int scheduleCourse(int[][] courses) {

        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int totalTime = 0;

        for (int[] course : courses) {

            int duration = course[0];
            int lastDay = course[1];

            totalTime += duration;
            maxHeap.offer(duration);

            if (totalTime > lastDay) {
                totalTime -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }

    public static void main(String[] args) {

        int[][] courses = {
                {100, 200},
                {200, 1300},
                {1000, 1250},
                {2000, 3200}
        };

        System.out.println(scheduleCourse(courses));
    }
}