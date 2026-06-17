public class Task23 {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 4};

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest && num != smallest) {
                secondSmallest = num;
            }
        }

        System.out.println("2nd Smallest Element = " + secondSmallest);
    }
}

