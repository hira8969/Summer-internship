package Arrays;
//188. Best Time to Buy and Sell Stock IV
public class BuySell {

    public static int maxProfit(int k, int[] prices) {

        int n = prices.length;

        if (n == 0 || k == 0)
            return 0;

        // Unlimited transactions case
        if (k >= n / 2) {

            int profit = 0;

            for (int i = 1; i < n; i++) {

                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {

            int maxDiff = -prices[0];

            for (int i = 1; i < n; i++) {

                dp[t][i] = Math.max(
                        dp[t][i - 1],
                        prices[i] + maxDiff
                );

                maxDiff = Math.max(
                        maxDiff,
                        dp[t - 1][i] - prices[i]
                );
            }
        }

        return dp[k][n - 1];
    }

    public static void main(String[] args) {

        int k = 2;

        int[] prices = {3, 2, 6, 5, 0, 3};

        int result = maxProfit(k, prices);

        System.out.println("Maximum Profit = " + result);
    }
}
