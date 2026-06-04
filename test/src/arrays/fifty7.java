package arrays;
// . Write a Java program to arrange the given character array into ascending order. input-{R, A, C, D, B} output-{A, B, C, D, R}    
public class fifty7 {

    public static void main(String[] args) {

        char[] arr = {'R', 'A', 'C', 'D', 'B'};

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {

                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.print("Output: {");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }
}