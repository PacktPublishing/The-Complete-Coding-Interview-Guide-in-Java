package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    // 'q' must be power of 2
    public static boolean isOdd(int p) {
        
        return ((p & 1) != 0);
    }
}
