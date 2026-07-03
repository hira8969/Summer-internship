package String;
//8. String to Integer (atoi)


    
import java.util.*;

public class StringtoInteger {
    public static int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        long num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            num = num * 10 + (s.charAt(i) - '0');

            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (sign * num);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));          // 42
        System.out.println(myAtoi("   -042"));    // -42
        System.out.println(myAtoi("1337c0d3"));   // 1337
        System.out.println(myAtoi("0-1"));        // 0
        System.out.println(myAtoi("words 987"));  // 0
    }
}