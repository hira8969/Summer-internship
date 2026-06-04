package arrays;
// Write a Java program for linear search.  
public class fourty6 {
    public static void main(String []a)
    {
        int arr[] = {1, 2, 3, 4, 5, 10 , 20, 78};
        int k = 10;
        linearSearch(arr, k);
        
    }
    static void linearSearch(int arr[], int k)
    {
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == k)
            {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found in the array.");
    }
}
