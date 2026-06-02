package arrays;

public class thirty6 {
    public static void main(String[] ar)
    {
        int arr[]= {1,2,3,4,5,6};
        insertAt3idx(arr, 3, 10);
    }
    static void insertAt3idx(int arr[], int index, int value)
    {
        if(index <0 || index > arr.length)
        {
            System.out.println("Invalid index");
            return;
        }
        int result[]= new int[arr.length +1];
        for(int i=0;i<index;i++)
        {
            result[i]= arr[i];
        }
        result[index]= value;
        for(int i=index;i<arr.length;i++)
        {
            result[i+1]= arr[i];
        }
        System.out.println("--after inserting element at index--");
        for (int i=0;i<result.length;i++)
        {
            System.out.print(result[i] + "  ");
        }
    }
}
