package arrays;
// Write a Java program for binary search. 
public class foutry7 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 10 , 20, 78};
        int k = 10;
        binarySearch(arr, k);
    }
    static void binarySearch(int arr[], int k)
    {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] == k)
            {
                System.out.println("Element found at index: " + mid);
                return;
            }
            else if(arr[mid] < k)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        System.out.println("Element not found in the array.");
    }

}
