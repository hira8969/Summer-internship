package arrays;

public record thirty3() {
    public static void main(String[] a)
    {
        int arr[]= {2,0,7,8,0,4,0,9,0,85};
        shiftZeroLeft(arr);
    }
    static void shiftZeroLeft(int arr[])
    {
        int result[]= new int[arr.length];
        int index=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] == 0)
            {
                result[index]= arr[i];
                index++;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] != 0)
            {
                result[index]= arr[i];
                index++;
            }
        }
        
        System.out.println("Array after shifting zeros to the left:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
