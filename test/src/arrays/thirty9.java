package arrays;

public class thirty9 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 5, 8, 9, 3, 1};
        commonelement(arr1, arr2);
    }
    static void commonelement(int arr1[], int arr2[])
    {
        boolean first = true;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    if (!first) System.out.print("  ");
                    System.out.print(arr1[i]);
                    first = false;
                    break;
                }
            }
        }        
    }
}
