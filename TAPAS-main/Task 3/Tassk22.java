public class Tassk22 {
  
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 4};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        System.out.println("2nd Largest Element = " + secondLargest);
    }
}

