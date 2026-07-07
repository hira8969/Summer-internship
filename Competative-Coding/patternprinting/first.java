package patternprinting;

public class first {
    public static void main(String ar[])
    {
        int i,j,k;
        for ( i=0;i<5;i++)
        {
            for (j=0;j<5-i;j++)
            {
                System.out.print(" ");
            }
            for(k=0;k<=i;k++)
            {
                System.out.print("* ");
            }   
            System.out.println(" ");
        }
    }
    
}
