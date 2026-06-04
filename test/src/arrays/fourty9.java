package arrays;

public class fourty9 {

    public static void main(String[] a) {

        int[] arr = {9, 5, 6, 1, 2, 7};

        selectionSort(arr);
    }
    static void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");

            
            
        }

    }
}