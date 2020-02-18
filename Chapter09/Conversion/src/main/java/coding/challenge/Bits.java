package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int count(int q, int p) {

        int count = 0;

        int xor = q ^ p; // each 1 in represents a bit that is different between q and p

        while (xor != 0) {
            count += xor & 1; // only 1 & 1 = 1
            xor = xor >> 1;
        }

        return count;
    }
}
