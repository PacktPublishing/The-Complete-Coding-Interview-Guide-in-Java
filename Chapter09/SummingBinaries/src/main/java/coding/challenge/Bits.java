package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int sum(int q, int p) {

        int xor;
        int and;
        int t;

        and = q & p;
        xor = q ^ p;

        while (and != 0) {

            and = and << 1;

            t = xor ^ and;
            and = and & xor;
            xor = t;
        }

        return xor;
    }
}
