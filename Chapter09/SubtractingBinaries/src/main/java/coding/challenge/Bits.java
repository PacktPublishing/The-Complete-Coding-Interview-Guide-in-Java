package coding.challenge;

public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int subtract(int q, int p) {

        while (p != 0) {
            
            // borrow is the unset bits of q AND set bits of p
            int borrow = (~q) & p;

            // subtraction of bits of q and p 
            // where at least one of the bits is not set
            q = q ^ p;
            
            // left shift borrow by one position            
            p = borrow << 1;
        }

        return q;
    }
}