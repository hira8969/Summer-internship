package Arrays;
//546. Remove Boxes


    
public class RemoveBoxes {
    int[][][] dp;
    int[] boxes;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        this.boxes = boxes;
        dp = new int[n][n][n];
        return dfs(0, n - 1, 0);
    }

    private int dfs(int l, int r, int k) {
        if (l > r) return 0;

        if (dp[l][r][k] != 0)
            return dp[l][r][k];

        while (r > l && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }

        int res = dfs(l, r - 1, 0) + (k + 1) * (k + 1);

        for (int i = l; i < r; i++) {
            if (boxes[i] == boxes[r] &&
                (i == l || boxes[i - 1] != boxes[r])) {

                res = Math.max(
                    res,
                    dfs(l, i, k + 1)
                    + dfs(i + 1, r - 1, 0)
                );
            }
        }

        return dp[l][r][k] = res;
    }

    public static void main(String[] args) {
        int[] boxes = {1,3,2,2,2,3,4,3,1};

        RemoveBoxes sol = new RemoveBoxes();
        System.out.println(sol.removeBoxes(boxes));
    }
}