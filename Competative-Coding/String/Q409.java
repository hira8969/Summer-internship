package String;
//409. Longest Palindrome
public class Q409 {
    
    public static int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : freq) {
            length += (count / 2) * 2;

            if (count % 2 == 1) {
                hasOdd = true;
            }
        }

        return hasOdd ? length + 1 : length;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
