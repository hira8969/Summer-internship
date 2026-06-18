package Arrays;


import java.util.*;
//118. Pascal's Triangle
public class pascaltringle {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {

                    row.add(1);

                } else {

                    int value =
                            result.get(i - 1).get(j - 1)
                          + result.get(i - 1).get(j);

                    row.add(value);
                }
            }

            result.add(row);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numRows = sc.nextInt();

        List<List<Integer>> ans = generate(numRows);

        for (List<Integer> row : ans) {

            for (int num : row) {

                System.out.print(num + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}
