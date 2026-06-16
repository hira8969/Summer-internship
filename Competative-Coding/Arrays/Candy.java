package Arrays;

import java.util.Arrays;

public class Candy {

    public static int candy(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];

        // Give each child 1 candy initially
        Arrays.fill(candies, 1);

        // Left to Right Pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left Pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i],
                                      candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        return totalCandies;
    }

    public static void main(String[] args) {

        int[] ratings = {1, 0, 2};

        int result = candy(ratings);

        System.out.println("Minimum Candies Required: " + result);
    }
}