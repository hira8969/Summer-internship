public class EvenIndexValues {
    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6};

        System.out.println("Even index values:");

        for(int i = 0; i < arr.length; i++) {

            if(i % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}