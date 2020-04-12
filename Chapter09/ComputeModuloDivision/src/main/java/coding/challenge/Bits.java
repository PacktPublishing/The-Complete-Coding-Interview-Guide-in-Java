package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    // 'q' must be power of 2
    public static int compute(int p, int q) {
        return p & (q - 1);
    }
}
