package arrays;


public class thirty8 {
    public static void main(String[] a) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 5, 8, 9, 3, 1};
        
        distinctelement(arr1, arr2);
    }
    static void distinctelement(int arr1[], int arr2[])
    {

        boolean first = true;
        // Elements of arr1 not present in arr2
        for (int i = 0; i < arr1.length; i++) {
            boolean found = false;

            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (!first) System.out.print("  ");
                System.out.print(arr1[i]);
                first = false;
            }
        }

        // Elements of arr2 not present in arr1
        for (int i = 0; i < arr2.length; i++) {
            boolean found = false;

            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                if (!first) System.out.print("  ");
                System.out.print(arr2[i]);
                first = false;
            }
        }        
    }
}
