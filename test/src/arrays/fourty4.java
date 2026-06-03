package arrays;

public class fourty4 {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 10 , 20, 78};
        int k = 2;

        removeEle(arr, k);
    }

    static void removeEle(int arr[], int k) {

        if (k >= arr.length) {
            System.out.println("Output: {}");
            return;
        }

        int result[] = new int[arr.length - k];

        for (int i = k; i < arr.length; i++) {
            result[i - k] = arr[i];
        }

        System.out.print("Output: {");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }
}