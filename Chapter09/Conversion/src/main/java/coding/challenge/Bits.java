package coding.challenge;
 
public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int count(int q, int p) {

        if (q < 0 || p < 0) {
            throw new IllegalArgumentException("The q and p numbers must be positive");
        }

        int count = 0;

        int xor = q ^ p; // each 1 represents a bit that is different between q and p

        while (xor != 0) {
            count += xor & 1; // only 1 & 1 = 1
            xor = xor >> 1;
        }

        return count;
    }
}
