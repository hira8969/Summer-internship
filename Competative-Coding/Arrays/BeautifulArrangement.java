package Arrays;

import java.util.*;

public class Main {

    static int count = 0;

    public static void backtrack(int pos, int n, boolean[] used) {

        if (pos > n) {
            count++;
            return;
        }

        for (int num = 1; num <= n; num++) {

            if (!used[num] && (num % pos == 0 || pos % num == 0)) {

                used[num] = true;

                backtrack(pos + 1, n, used);

                used[num] = false; // Backtrack
            }
        }
    }

    public static int countArrangement(int n) {

        boolean[] used = new boolean[n + 1];

        backtrack(1, n, used);

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countArrangement(n));

        sc.close();
    }
}