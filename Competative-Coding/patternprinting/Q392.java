package patternprinting;

//392. Is Subsequence

public class Q392 {
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "abc";
        String t = "ahbgdc";

        System.out.println(sol.isSubsequence(s, t));
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}