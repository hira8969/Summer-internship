package arrays;

import java.util.Arrays;

public class fourty1 {
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,13};
        missingValues(arr);
    }

    static void missingValues(int arr[]) {

        Arrays.sort(arr);

        System.out.print("Missing Elements:  ");

        boolean first = true;

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = arr[i] + 1; j < arr[i + 1]; j++) {

                if (!first) {
                    System.out.print(" ");
                }

                System.out.print(j);
                first = false;
            }
        }

        
    }
}