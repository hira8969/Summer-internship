package String;

public class ValidNumber {
    
public class Main {

    public static boolean isNumber(String s) {
        return s.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        String s = "2e10";

        if (isNumber(s)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}