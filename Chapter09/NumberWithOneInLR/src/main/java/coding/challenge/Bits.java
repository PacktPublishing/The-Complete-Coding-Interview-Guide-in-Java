package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int setBetween(int left, int right) {
        return (1 << (right + 1)) - (1 << left);
    }
}
