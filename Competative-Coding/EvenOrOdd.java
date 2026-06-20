public class EvenOrOdd {
    public static void main(String[] args) {
        int number = 7; // You can change this number to test with  
        if ((number & 1) == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}