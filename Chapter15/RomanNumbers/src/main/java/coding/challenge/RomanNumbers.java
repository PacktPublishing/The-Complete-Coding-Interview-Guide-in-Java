package coding.challenge;
 
public final class RomanNumbers {

    // the following constants are used by convert1()
    private static final String HUNDREDTHS[]
            = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String TENS[]
            = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String ONES[]
            = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    // the following constants are used by convert2()
    private static final int[] DECIMALS
            = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMANS
            = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private RomanNumbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* using division */
    public static String convert1(int n) {

        if (n <= 0) {
            return "";
        }

        String roman = "";

        while (n >= 1000) {
            roman = roman + 'M';
            n -= 1000;
        }

        roman = roman + HUNDREDTHS[n / 100];
        n = n % 100;

        roman = roman + TENS[n / 10];
        n = n % 10;

        roman = roman + ONES[n];

        return roman;
    }

    /* using subtraction */
    public static String convert2(int n) {

        if (n <= 0) {
            return "";
        }

        String roman = "";
        int i = 0;

        while (n > 0) {
            if (n >= DECIMALS[i]) {
                roman += ROMANS[i];
                n -= DECIMALS[i];
            } else {
                i++;
            }
        }

        return roman;
    }
}
