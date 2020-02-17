package coding.challenge;

public final class Bits {   
    
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }
    
    public static int replace(int q, int p, int i, int j) {
        int ones = ~0; // 11111111 11111111 11111111 11111111          
        
        int leftShiftJ = ones << (j + 1); 
        int leftShiftI = ((1 << i) - 1); 
        
        int mask = leftShiftJ | leftShiftI; 
        
        int applyMaskToQ = q & mask;                        
        int bringPInPlace = p << i;        

        return applyMaskToQ | bringPInPlace; 
    }
}
