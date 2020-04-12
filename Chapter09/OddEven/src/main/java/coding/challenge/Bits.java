package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }
       
    public static boolean isOdd(int p) {
        
        return ((p & 1) != 0);
    }
}
