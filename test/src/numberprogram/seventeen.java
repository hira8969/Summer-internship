package numberprogram;

import java.util.Scanner;

public class seventeen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        prime(num);
	}
	public static void prime(int n) {
		System.out.print(" Prime numer is: ");
		for(int i = 2; i <= n; i++) {

            boolean isPrime = true;

            for(int j = 2; j <= i / 2; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                System.out.print(i + " ");
            }
        }
	}

}
