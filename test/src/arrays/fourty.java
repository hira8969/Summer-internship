package arrays;

public class fourty {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        halfarrleft(arr);
    }

    static void halfarrleft(int arr[]) {
        int n = arr.length;
        int half = n / 2;

        int result[] = new int[n];

        // Right half ko left me copy karo
        for (int i = half; i < n; i++) {
            result[i - half] = arr[i];
        }

        // Left half ko right me copy karo
        for (int i = 0; i < half; i++) {
            result[i + half] = arr[i];
        }

        System.out.println("After swapping halves:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}