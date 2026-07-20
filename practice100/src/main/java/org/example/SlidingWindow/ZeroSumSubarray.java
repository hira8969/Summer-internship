package org.example.SlidingWindow;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 5, 5, 0, 0};
        ZeroSum(arr);
    }
    public static void ZeroSum(int [] arr)
    {
        int total=0;
        int n= arr.length;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum +=arr[j];
                if(sum ==0)
                    total++;
            }
        }
        System.out.println("Total number of subarr with SUm 0: "+total);
    }
}
