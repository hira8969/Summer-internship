package org.example;

import java.util.Scanner;

public class Swap2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Two number ");
        int a= sc.nextInt();
        int b= sc.nextInt();
        System.out.println("Before Swapping number " + a+ "  "+ b);
        swap(a,b);
    }
    static void swap(int a, int b)
    {
        int temp= a;
        a=b;
        b=temp;
        System.out.println("After Swapping number "+ a+ "  "+ b);
    }
}
