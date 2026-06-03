public class fourty2 {

    static String[] ones = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    static String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    static String convert(int n) {

        if (n == 0)
            return "Zero";

        if (n < 20)
            return ones[n];

        if (n < 100)
            return tens[n / 10] + " " + ones[n % 10];

        if (n < 1000)
            return ones[n / 100] + " Hundred " + convert(n % 100);

        return "Number too large";
    }

    public static void main(String[] args) {
        int num = 123;
        System.out.println(convert(num));
    }
}