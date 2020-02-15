package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static char getBitValue(int n, int position) {

        if (position < 0 || position > 32) {
            throw new IllegalArgumentException("The position must be between 0 and 32");
        }

        int result = n & (1 << position);

        if (result == 0) {
            return '0';
        }

        return '1';
    }
}
