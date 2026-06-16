package arrays;

public class thirty2 {
    public static void main(String[] a)
    {
        int arr[]= {2,0,7,8,0,4,0,9,0,85};
        shiftZeroRight(arr);
    }
    static void shiftZeroRight(int arr[])
    {
        int result[]= new int[arr.length];
        int index=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] != 0)
            {
                result[index]= arr[i];
                index++;
            }
        }
        
        System.out.println("Array after shifting zeros to the right:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
