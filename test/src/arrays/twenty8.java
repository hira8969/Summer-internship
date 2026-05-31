package arrays;

public class twenty8 {
	public static int reverseNumber(int num) {
        int rev = 0;

        while (num > 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }

        return rev;
    }

    public static void main(String[] args) {

        int[] arr = {23, 55, 57, 93, 1};

        System.out.print("Output: {");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(reverseNumber(arr[i]));

            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }

        System.out.println("}");
    }
}
