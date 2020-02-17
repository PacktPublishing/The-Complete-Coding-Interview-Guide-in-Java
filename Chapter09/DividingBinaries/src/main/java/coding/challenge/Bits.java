package coding.challenge;

public final class Bits {

    private static final int MAX_BIT = 31;
    
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static long divide(long q, long p) {

        // obtain the sign of the division
        long sign = ((q < 0) ^ (p < 0)) ? -1 : 1;

        // ensure that q and p are positive
        q = Math.abs(q);
        p = Math.abs(p);

        long t = 0;
        long quotient = 0;        

        // 
        for (int i = MAX_BIT; i >= 0; --i) {
            
            long halfdown = t + (p << i);              
            
            if (halfdown <= q) {
                
                t = t +  p << i;
                quotient = quotient | 1L << i;
            }
        }

        return sign * quotient;
    }
}
