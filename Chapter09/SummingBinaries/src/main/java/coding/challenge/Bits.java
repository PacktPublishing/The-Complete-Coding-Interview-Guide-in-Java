package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    // using the equation, p + q = 2 * (p & q) + (p ^ q)
    public static int sum(int q, int p) {

        int xor;
        int and;
        int t;
        
        and = q & p;
        xor = q ^ p;

        // force and to return 0
        while (and != 0) {

            and = and << 1; // this is multiplication by 2

            // prepare the next step of recursion
            t = xor ^ and;
            and = and & xor;
            xor = t;
        }

        return xor;
    }
}
