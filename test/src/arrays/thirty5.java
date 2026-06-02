package arrays;

public class thirty5 {
    public static void main(String [] ar)
    {
        int arr[]= {1,2,3,4,2,3};
    }
    static void printrepeted(int arr[])
    {
            System.out.println("Repeted element in the array:");
            for(int i=0;i<arr.length;i++)
            {
                for(int j=i+1;j<arr.length;j++)
                {
                    if(arr[i] == arr[j])
                    {
                        System.out.print(arr[i] + "  ");
                        break;
                    }
                }
            }
    }
}

