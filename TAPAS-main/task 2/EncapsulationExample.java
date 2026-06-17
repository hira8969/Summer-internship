class Student {
    // Private variable
    private int age;

    // Setter method
    public void setAge(int age) {
        this.age = age;
    }

    // Getter method
    public int getAge() {
        return age;
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
        Student s = new Student();

        s.setAge(20);

        System.out.println("Student Age: " + s.getAge());
    }
}