package coding.challenge;
 
public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int next(int n) {

        int copyn = n;

        int zeros = 0;
        int ones = 0;

        // count trailing 0s
        while ((copyn != 0) && ((copyn & 1) == 0)) {
            zeros++;
            copyn = copyn >> 1;
        }

        // count all 1s until first 0
        while ((copyn & 1) == 1) {
            ones++;
            copyn = copyn >> 1;
        }

        // the 1111...000... is the biggest number without adding more 1
        if (zeros + ones == 0 || zeros + ones == 31) {
            return -1;
        }

        int marker = zeros + ones;

        n = n | (1 << marker);
        n = n & (-1 << marker);
        n = n | (1 << (ones - 1)) - 1;

        return n;
    }

    public static int previous(int n) {

        int copyn = n;

        int zeros = 0;
        int ones = 0;

        // count trailing 1s
        while ((copyn & 1) == 1) {
            ones++;
            copyn >>= 1;
        }

        // the 0000...111... is the smallest number without adding more 1
        if (copyn == 0) {
            return -1;
        }
        
        // count all 0s until first 1
        while ((copyn != 0) && ((copyn & 1) == 0)) {
            zeros++;
            copyn >>= 1;
        }

        int marker = zeros + ones;
        
        n = n & (-1 << (marker + 1));
        int mask = (1 << (ones + 1)) - 1; 
        n = n | mask << (zeros - 1);

        return n;
    }
}
