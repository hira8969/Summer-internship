package arrays;

public class thirty1 {
    public static void main(String[] ar)
    {
        int arr1[]= {1,2,3,4,5,6};
        int arr2[]= {7,8,9,10};
        mergTwoarray(arr1, arr2);   
    }
    static void mergTwoarray(int arr1[], int arr2[])
    {
        int result[]= new int[arr1.length + arr2.length];
        for(int i=0;i<arr1.length;i++)
        {
            result[i]= arr1[i];
        }
        for(int i=0;i<arr2.length;i++)
        {
            result[arr1.length + i]= arr2[i];
        }
        System.out.println("-------after merging two array-------");
        for (int i=0;i<result.length;i++)
        {
            System.out.print(result[i] + "  ");
        }
    }
}
