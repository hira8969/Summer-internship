package org.example;

import java.util.Scanner;

public class CheckVowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String Here: ");
        String s = sc.nextLine();

        checkVowel(s);
    }
    static void checkVowel(String s) {
        int count = 0;

        for (char ch : s.toLowerCase().toCharArray()) {

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

                count++;
                System.out.println(ch + " is a vowel");
            }
        }

        System.out.println("Total Vowels = " + count);
    }
}
