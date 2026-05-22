package numberprogram;

import java.util.Scanner;

public class thirteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String num = sc.nextLine();
        duck(num);

        
	}
	public static void duck(String num)
	{
		if(num.charAt(0) == '0') {
            System.out.println(num + " is not a Duck Number");
        }
        else if(num.contains("0")) {
            System.out.println(num + " is a Duck Number");
        }
        else {
            System.out.println(num + " is not a Duck Number");
        }
	}

}
