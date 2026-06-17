/*2. Write a program to check whether a number is positive, negative, or zero */

import java.util.Scanner;

public class Number {
    
    // Method to check if a number is positive, negative, or zero
    public static void checkNumber(int num) {
        if (num > 0) {
            System.out.println(num + " is a positive number");
        } else if (num < 0) {
            System.out.println(num + " is a negative number");
        } else {
            System.out.println(num + " is zero");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        checkNumber(number);
        
        sc.close();
    }
}
