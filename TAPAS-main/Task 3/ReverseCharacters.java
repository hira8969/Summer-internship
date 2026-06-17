public class ReverseCharacters {
    public static void main(String[] args) {

        char arr[] = {'A', 'B', 'C', 'D', 'E'};

        System.out.println("Characters in reverse order:");

        for(int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}