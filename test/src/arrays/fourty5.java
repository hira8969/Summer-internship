package arrays;
import java.util.Arrays;
//45. Write a Java program to copy an array using arraycopy() method.  
public class fourty5
{
    public static void main(String [] a)
    {
        int arr[] = {1, 2, 3, 4, 5, 10 , 20, 78};
        int result[] = new int[arr.length];
        result = Arrays.copyOf(arr, arr.length);
        for(int i: result)
        {
            System.out.print(i + " ");
        }
    }
}