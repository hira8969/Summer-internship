package String;

public class RomantoInteger {
    


    public static int romanToInt(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            int curr = value(s.charAt(i));

            if (i < s.length() - 1 && curr < value(s.charAt(i + 1))) {
                ans -= curr;
            } else {
                ans += curr;
            }
        }

        return ans;
    }

    private static int value(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));      // 3
        System.out.println(romanToInt("LVIII"));    // 58
        System.out.println(romanToInt("MCMXCIV"));  // 1994
    }
}