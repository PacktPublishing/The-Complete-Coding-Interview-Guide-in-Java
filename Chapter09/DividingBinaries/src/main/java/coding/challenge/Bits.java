package coding.challenge;
 
public final class Bits {

    private static final int MAX_BIT = 31;

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static long divideWithRemainder(long q, long p) {

        if (p == 0) {
            throw new ArithmeticException("Division by 0");
        }

        // obtain the sign of the division
        long sign = ((q < 0) ^ (p < 0)) ? -1 : 1;

        // ensure that q and p are positive
        q = Math.abs(q);
        p = Math.abs(p);

        long t = 1;
        long quotient = 0;

        while (p <= q) {
            p = p << 1;
            t = t << 1;
        }

        while (t > 1) {
            p = p >> 1;
            t = t >> 1;
            if (q >= p) {
                q -= p;
                quotient = quotient | t;
            }
        }

        System.out.println("Remainder is: " + q);

        return sign * quotient;
    }

    public static long divideWithoutRemainder(long q, long p) {

        if (p == 0) {
            throw new ArithmeticException("Division by 0");
        }

        // obtain the sign of the division
        long sign = ((q < 0) ^ (p < 0)) ? -1 : 1;

        // ensure that q and p are positive
        q = Math.abs(q);
        p = Math.abs(p);

        long t = 0;
        long quotient = 0;

        for (int i = MAX_BIT; i >= 0; --i) {

            long halfdown = t + (p << i);

            if (halfdown <= q) {

                t = t + p << i;
                quotient = quotient | 1L << i;
            }
        }

        return sign * quotient;
    }
}
