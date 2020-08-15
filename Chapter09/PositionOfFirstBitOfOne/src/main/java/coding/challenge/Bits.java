package coding.challenge;
 
public final class Bits {

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int findPosition(int n) {
                  
        int count = 0;
        
        if(!isPowerOfTwo(n)) {
            return -1;
        }
                
        while (n != 0) {
            n = n >> 1;          
            ++count;
        }

        return count;
    }

    private static boolean isPowerOfTwo(int n) {

        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
