/* Write a program to check if a number is a Neon number */
import java.util.Scanner;
public class Neonnumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int square = num * num;
        int sum = 0;
        int temp = square;

        // Calculate the sum of the digits of the square
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (num == sum) {
            System.out.println(num + " is a Neon number.");
        } else {
            System.out.println(num + " is not a Neon number.");
        }
    }
}
