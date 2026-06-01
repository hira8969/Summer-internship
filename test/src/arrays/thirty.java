package arrays;

public class thirty {
    public static void main(String[] args) {

        int[] arr = { 231, 554, 572, 962, 24, 1 };
        addeven(arr);
    }

    static void addeven(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];
            int sum = 0;

            while (num > 0) {
                int digit = num % 10;

                if (digit % 2 == 0) {
                    sum += digit;
                }

                num /= 10;
            }

            result[i] = sum;
        }

        System.out.print("{");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i < result.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}
