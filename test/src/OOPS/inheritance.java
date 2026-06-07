package OOPS;

class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving");
    }
}
public class inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated met
		Car c= new Car();
		c.start();  // call parent call method 
		c.drive();  // call child class method 
	}

}

