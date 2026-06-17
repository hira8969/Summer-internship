/*4. Write a program to swap two numbers without using a third variable */
import java.util.Scanner;
public class Swapwithout {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        
        System.out.println("Before swapping:");
        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
        
        // Swapping without using a third variable
        num1 = num1 + num2; 
        num2 = num1 - num2; 
        num1 = num1 - num2; 
        
        System.out.println("After swapping:");
        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
        
        sc.close();
    }
    
}
