package coding.challenge;

public final class Digits {

    private Digits() {
        throw new AssertionError("Cannot be instantiated");
    }

    /* Recursive approach */
    public static int decoding(char[] digits, int n) {

        // base cases 
        if (n == 0 || n == 1) {
            return 1;
        }

        // if the digits[] starts with 0 (for example, '0212')
        if (digits == null || digits[0] == '0') {
            return 0;
        }

        int count = 0;

        // If the last digit is not 0 then last digit must add to the number of words 
        if (digits[n - 1] > '0') {
            count = decoding(digits, n - 1);
        }

        // If the last two digits represents a number smaller than or equal to 26
        // then consider last two digits and call decoding()
        if (digits[n - 2] == '1'
                || (digits[n - 2] == '2' && digits[n - 1] < '7')) {
            count += decoding(digits, n - 2);
        }

        return count;
    }

    /* Dynamic Programming solution */
    public static int decoding(char digits[]) {

        // if the digits[] starts with 0 (for example, '0212')
        if (digits == null || digits[0] == '0') {
            return 0;
        }

        int n = digits.length;

        // store results of sub-problems 
        int count[] = new int[n + 1];

        count[0] = 1;
        count[1] = 1;

        for (int i = 2; i <= n; i++) {
            count[i] = 0;

            // If the last digit is not 0 then last digit must add to the number of words 
            if (digits[i - 1] > '0') {
                count[i] = count[i - 1];
            }

            // If the second last digit is smaller than 2 and the last digit is smaller 
            // than 7, then last two digits represent a valid character 
            if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7')) {
                count[i] += count[i - 2];
            }
        }

        return count[n];
    }
}
