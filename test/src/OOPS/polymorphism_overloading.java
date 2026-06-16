package OOPS;

class MathOperation {

    void add(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    void add(int a, int b, int c) {
        System.out.println("Sum = " + (a + b + c));
    }
}

public class polymorphism_overloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathOperation m = new MathOperation();

        m.add(10, 20);
        m.add(10, 20, 30);
		

	}

}
