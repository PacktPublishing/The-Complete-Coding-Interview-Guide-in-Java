package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int sequence(int n) {

        if (~n == 0) {
            return Integer.SIZE; // 32
        }

        int currentSequence = 0;
        int longestSequence = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                currentSequence++;
            } else if ((n & 1) == 0) {
                currentSequence = ((n & 0b10) == 0) ? 0 : ++currentSequence;
            }

            longestSequence = Math.max(currentSequence, longestSequence);

            n >>>= 1;
        }

        return longestSequence;
    }
}
