package arrays;

import java.util.Arrays;
// Write a Java program to arrange the given string array into ascending order. input-{“Ram”,” Amar”,” Cel”,” David”,” Bunny”} output-{” Amar”,” Bunny”,” Cel”,” David”,”Ram”}   
public class fifty6 {

    public static void main(String[] args) {

        String[] names = {"Ram", "Amar", "Cel", "David", "Bunny", "Hira"};

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