package patternprinting;

public class DiamondPattern {
    public static void main(String[] args) {
        int n = 5;

        // Upper Half
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        
    }
}
