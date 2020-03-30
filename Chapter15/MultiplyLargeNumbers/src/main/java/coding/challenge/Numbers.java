package coding.challenge;

public final class Numbers {

    private Numbers() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String multiply(String a, String b) {

        if (a == null || b == null) {
            throw new IllegalArgumentException("a and b cannot be null");
        }

        int lenA = a.length();
        int lenB = b.length();

        if (lenA == 0 || lenB == 0) {
            return "0";
        }

        // the result of multiplication is stored in reverse order 
        int c[] = new int[lenA + lenB];

        // indexes to find positions in result
        int idx1 = 0;
        int idx2 = 0;

        // loop 'a' right to left
        for (int i = lenA - 1; i >= 0; i--) {

            int carry = 0;
            int n1 = a.charAt(i) - '0';

            // used to shift position to left after every multiplication of a digit in 'b' 
            idx2 = 0;

            // loop 'b' from right to left
            for (int j = lenB - 1; j >= 0; j--) {

                // current digit of second number 
                int n2 = b.charAt(j) - '0';

                // multiply with current digit of first number 
                int sum = n1 * n2 + c[idx1 + idx2] + carry;

                // carry of the next iteration
                carry = sum / 10;
                
                c[idx1 + idx2] = sum % 10;
                idx2++;
            }

            // store carry 
            if (carry > 0) {
                c[idx1 + idx2] += carry;
            }

            // shift position to left after every multiplication of a digit in 'a' 
            idx1++;
        }

        // ignore '0's from the right 
        int i = c.length - 1;
        while (i >= 0 && c[i] == 0) {
            i--;
        }

        // If all were '0's - means either both or one of 'a' or 'b' were '0' 
        if (i == -1) {
            return "0";
        }
        
        String result = "";
        while (i >= 0) {
            result += (c[i--]);
        }

        return result;
    }
}
