package coding.challenge;
 
public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int swap(int n) {

        if (n < 0) {
            return -1;
        }

        int moveToEvenPositions = (n & 0b10101010101010101010101010101010) >>> 1;
        int moveToOddPositions = (n & 0b1010101010101010101010101010101) << 1;

        return moveToEvenPositions | moveToOddPositions;
    }
}
