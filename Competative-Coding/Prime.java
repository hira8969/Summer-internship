
package ClassProblem;
import java.util.Scanner;
public class Prime {
    static void main() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter numbr Here: ");
        int n=sc.nextInt();
        prime2(n);

    }
    static  void prime2(int a ){

        int count=0;
        for(int i=1;i<=a;i++)
        {
            if(a%i==0)
            {
                count++;
            }
        }
        if(count ==2)
        {
            System.out.println(a + "number is prime ");
        }
        else{
            System.out.println(a+ "not a prime number ");
        }
    }
}