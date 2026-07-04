package String;

public class FirstOccurrenceString {
    
import java.util.*;

public class Main {

    public static int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter haystack: ");
        String haystack = sc.nextLine();

        System.out.print("Enter needle: ");
        String needle = sc.nextLine();

        int ans = strStr(haystack, needle);

        System.out.println("Output: " + ans);

        sc.close();
    }
}