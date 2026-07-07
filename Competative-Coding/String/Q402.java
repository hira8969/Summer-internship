package String;
//402. Remove K Digits
public class Q402 {
    


    public static String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0') {
            i++;
        }

        String result = stack.substring(i);

        return result.isEmpty() ? "0" : result;
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        System.out.println(removeKdigits(num, k));
    }
}