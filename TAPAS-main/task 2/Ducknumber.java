/*Write a program to check whether a number is a Duck number */
import java.util.Scanner;
public class Ducknumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        int temp = num;
        boolean hasZero = false;

        // Check if the number contains zero
        while (temp != 0) {
            if (temp % 10 == 0) {
                hasZero = true;
                break;
            }
            temp /= 10;
        }

        if (hasZero) {
            System.out.println(num + " is a Duck number.");
        } else {
            System.out.println(num + " is not a Duck number.");
        }
    }
}
