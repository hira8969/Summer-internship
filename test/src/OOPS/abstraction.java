package OOPS;
abstract class Animal {

    abstract void sound();

    void sleep() {
        System.out.println("Animal is sleeping");
    }
}
class Dog extends Animal {

    // Providing implementation
    void sound() {
        System.out.println("Dog barks");
    }
}

public class abstraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog d = new Dog();

        d.sound();
        d.sleep();
	}

}
