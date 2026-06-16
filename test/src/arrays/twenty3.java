package arrays;

public class twenty3 {

    public static void main(String[] args) {

        int arr[] = {1, 2, 1, 3, 0, 4};

        secondSmall(arr);
    }

    public static void secondSmall(int arr[]) {

    
        if (arr.length < 2) {
            System.out.println("Second smallest element not possible");
            return;
        }

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {

            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            }

            else if (num != smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("No second smallest element");
        } else {
            System.out.println("Second Smallest Element = " + secondSmallest);
        }
    }
}