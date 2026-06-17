/*Write a program to find the size and range of primitive data types. */


    public class Third {
    public static void main(String[] args) {
        System.out.println("Java primitive data types: size and range\n");

        print("byte", Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE);
        print("short", Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE);
        print("int", Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        print("long", Long.SIZE, Long.MIN_VALUE, Long.MAX_VALUE);
        print("float", Float.SIZE, Float.MIN_VALUE, Float.MAX_VALUE);
        print("double", Double.SIZE, Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.println("char : " + Character.SIZE + " bits, range: " +
                (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE);
        System.out.println("boolean : size not precisely defined by Java; values are false and true");
    }

    private static void print(String name, int bits, Number min, Number max) {
        System.out.printf("%-7s : %2d bits, range: %s to %s%n", name, bits, min, max);
    }
}
