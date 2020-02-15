package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int setBitValueTo1(int n, int k) {

        if (k < 0 || k > 32) {
            throw new IllegalArgumentException("The position must be between 0 and 32");
        }

        return n | (1 << k);
    }
    
    public static int setBitValueTo0(int n, int k) {

        if (k < 0 || k > 32) {
            throw new IllegalArgumentException("The position must be between 0 and 32");
        }

        return n & ~(1 << k);
    }
}
