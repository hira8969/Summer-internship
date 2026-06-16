package arrays;

public class thirty4 {
    public static void main(String[] ar)
    {
        int arr[]= {1,2,3,4,5,6};
        lengtharr(arr);
          
    }
    static void lengtharr(int arr[])
    {
        int count =0;
        for(int ele:arr)
        {
            count++;

        }
        System.out.println("Length of the array: " + count);
    }
}
