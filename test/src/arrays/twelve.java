package arrays;

public class twelve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 char[] arr = {'a', 'b', 'e', 'f', 'i', 'x', 'o', 'u'};

	      vowel(arr);
	}
	public static void vowel(char arr[])
	{
		System.out.println("Vowels present in array are:");

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' ||
                arr[i] == 'o' || arr[i] == 'u' ||
                arr[i] == 'A' || arr[i] == 'E' || arr[i] == 'I' ||
                arr[i] == 'O' || arr[i] == 'U') {

                System.out.print(arr[i] + "  ");
            }
        }
	}

}
