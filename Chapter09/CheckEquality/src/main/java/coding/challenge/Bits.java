package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }
        
    public static boolean checkEquality(int p, int q) {
        
        return ((p ^ q) == 0);
    }
}
