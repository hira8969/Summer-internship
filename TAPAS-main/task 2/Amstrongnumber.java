/* Write a program to check if a number is an Armstrong number */
import java.util.Scanner;
public class Amstrongnumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int original = num;
        int sum = 0;
        int digits = 0;
        int temp = num;
        
        // Count the number of digits
        while (temp != 0) {
            digits++;
            temp /= 10;
        }
        
        // Calculate the sum of each digit raised to the power of the number of digits
        temp = num;
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        
        if (original == sum) {
            System.out.println(original + " is an Armstrong number.");
        } else {
            System.out.println(original + " is not an Armstrong number.");
        }
    }
}
