package arrays;

public class eleven {
	
	public static boolean isPrime(int num) {

		if (num <= 1) {
			return false;
		}

		for (int i = 2; i < num; i++) {

			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,7,8,9,10};
		System.out.print("Prime Numbers: ");

		for (int num : arr) {

			if (isPrime(num)) {
				System.out.print(num + " ");
			}
		}
		
	}

}
