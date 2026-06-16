public class twenty9 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 1};
        int[] arr2 = {2, 3, 5, 6, 7, 8, 9};
        addarray(arr1, arr2);
        
    }
    static void addarray(int[] arr1, int[] arr2) {
        int maxLength = Math.max(arr1.length, arr2.length);
        int[] result = new int[maxLength];

        int i = 0;
        for (; i < Math.min(arr1.length, arr2.length); i++) {
            result[i] = arr1[i] + arr2[i];
        }
        while (i < arr1.length) {
            result[i] = arr1[i];
            i++;
        }

        while (i < arr2.length) {
            result[i] = arr2[i];
            i++;
        }

        System.out.print("{");
        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j]);
            if (j < result.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}
