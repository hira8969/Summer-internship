package Arrays;

import java.util.*;

public class WordBreak2 {

    public static List<String> wordBreak(String s,
                                         List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        return dfs(s, set, new HashMap<>());
    }

    private static List<String> dfs(String s,
                                    Set<String> set,
                                    Map<String, List<String>> memo) {

        if (memo.containsKey(s))
            return memo.get(s);

        List<String> result = new ArrayList<>();

        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : set) {

            if (s.startsWith(word)) {

                List<String> sub =
                        dfs(s.substring(word.length()), set, memo);

                for (String str : sub) {
                    result.add(word +
                            (str.isEmpty() ? "" : " " + str));
                }
            }
        }

        memo.put(s, result);

        return result;
    }

    public static void main(String[] args) {

        String s = "catsanddog";

        List<String> wordDict =
                Arrays.asList("cat","cats","and","sand","dog");

        System.out.println(wordBreak(s, wordDict));
    }
}