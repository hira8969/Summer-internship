
package String;

public class LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        return words[words.length - 1].length();
    }

    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println("Length of last word: " + lengthOfLastWord(s));
    }
}