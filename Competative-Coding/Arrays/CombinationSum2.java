package Arrays;

import java.util.*;
//40. Combination Sum II

public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private static void backtrack(int[] candidates,
                                  int target,
                                  int start,
                                  List<Integer> current,
                                  List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            backtrack(candidates,
                      target - candidates[i],
                      i + 1,
                      current,
                      result);

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> ans = combinationSum2(candidates, target);

        System.out.println(ans);
    }
}