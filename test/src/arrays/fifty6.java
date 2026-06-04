package arrays;

import java.util.Arrays;

public class fifty6 {

    public static void main(String[] args) {

        String[] names = {"Ram", "Amar", "Cel", "David", "Bunny"};

        Arrays.sort(names);

        System.out.print("Output: {");

        for (int i = 0; i < names.length; i++) {
            System.out.print("\"" + names[i] + "\"");

            if (i < names.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("}");
    }
}