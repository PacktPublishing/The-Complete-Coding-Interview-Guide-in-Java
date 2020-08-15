package coding.challenge;
 
public final class Bits {
    
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int multiply(int q, int p) {

        int result = 0;
        
        while (p != 0) {

            // we compute the value of q only when the LSB of p is 1            
            if ((p & 1) != 0) {
                result = result + q;                
            }

            q = q << 1;  // q is left shifted with one position
            p = p >>> 1; // p is logical right shifted with one position
        }

        return result;
    }
}
