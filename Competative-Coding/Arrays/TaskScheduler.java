package Arrays;
//621. Task Scheduler
   
import java.util.*;
public class TaskScheduler {


    public static int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        return Math.max(
                tasks.length,
                (maxFreq - 1) * (n + 1) + maxCount
        );
    }

    public static void main(String[] args) {

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }
}