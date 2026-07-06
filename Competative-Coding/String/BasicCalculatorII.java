package String;

public class BasicCalculatorII {
    
import java.util.Scanner;

public class Main {

    public static int calculate(String s) {
        int result = 0;
        int lastNum = 0;
        int currNum = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                switch (op) {
                    case '+':
                        result += lastNum;
                        lastNum = currNum;
                        break;

                    case '-':
                        result += lastNum;
                        lastNum = -currNum;
                        break;

                    case '*':
                        lastNum = lastNum * currNum;
                        break;

                    case '/':
                        lastNum = lastNum / currNum;
                        break;
                }

                op = ch;
                currNum = 0;
            }
        }

        return result + lastNum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression: ");
        String s = sc.nextLine();

        System.out.println("Result = " + calculate(s));

        sc.close();
    }
}