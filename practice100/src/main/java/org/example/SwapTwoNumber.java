package org.example;

import java.util.Scanner;

public class SwapTwoNumber {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter number here : ");
        int num1= sc.nextInt();
        int num2= sc.nextInt();
        System.out.println("Before Swapping Number: " + num1 + "  "+ num2);
        swap(num1, num2);
    }
    static void swap(int a, int b)
    {
        a= a+b;
        b= a-b;
        a=a-b;
        System.out.println("After Swapping Number " + a + "   "+ b);
    }
}
