package String;

public class ShortestPalindrome {
    
class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();

        // Find the longest palindromic prefix
        int end = n;
        while (end > 0) {
            if (isPalindrome(s, 0, end - 1)) {
                break;
            }
            end--;
        }

        String suffix = s.substring(end);
        StringBuilder result = new StringBuilder(suffix).reverse();
        result.append(s);

        return result.toString();
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}