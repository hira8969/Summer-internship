package Arrays;


    
import java.util.*;

public class FindaSafeWalk {
    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);

        if (startHealth <= 0) {
            return false;
        }

        int[][] best = new int[m][n];
        for (int[] row : best) {
            Arrays.fill(row, -1);
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> b[2] - a[2]);

        pq.offer(new int[]{0, 0, startHealth});
        best[0][0] = startHealth;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!pq.isEmpty()) {

            int[] cur = pq.poll();

            int x = cur[0];
            int y = cur[1];
            int h = cur[2];

            if (x == m - 1 && y == n - 1) {
                return true;
            }

            if (h < best[x][y]) {
                continue;
            }

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                int newHealth = h - grid.get(nx).get(ny);

                if (newHealth <= 0) {
                    continue;
                }

                if (newHealth > best[nx][ny]) {
                    best[nx][ny] = newHealth;
                    pq.offer(new int[]{nx, ny, newHealth});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        List<List<Integer>> grid = Arrays.asList(
                Arrays.asList(0, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 1, 0),
                Arrays.asList(0, 0, 0, 1, 0)
        );

        int health = 1;

        System.out.println(findSafeWalk(grid, health));
    }
}