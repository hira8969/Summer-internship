package OOPS;

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}


class Dog extends Animal {

   
    void sound() {
    	
        System.out.println("Dog barks");
    }
}

public class overriding {

	public static void main(String[] args) {
		// TOD 
		Dog d= new Dog();
		d.sound();
	}

}
