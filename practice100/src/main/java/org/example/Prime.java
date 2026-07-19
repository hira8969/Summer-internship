package org.example;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number Here: ");
        int n = sc.nextInt();

        prime2(n);

        sc.close();
    }
    public static void prime2(int a) {

        int count = 0;

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            System.out.println(a + " is a prime number");
        } else {
            System.out.println(a + " is not a prime number");
        }
    }
}
