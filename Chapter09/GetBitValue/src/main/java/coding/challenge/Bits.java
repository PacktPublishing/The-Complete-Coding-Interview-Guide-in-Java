package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static char getValue(int n, int k) {

        if (k < 0 || k > 31) {
            throw new IllegalArgumentException("The position must be between 0 and 31");
        }

        int result = 1 & (n >> k);
        // or, int result = n & (1 << k);

        if (result == 0) {
            return '0';
        }

        return '1';
    }
}
