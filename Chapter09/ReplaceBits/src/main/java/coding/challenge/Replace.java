package coding.challenge;

public class Replace {

    int replaceBits(int q, int p, int i, int j) {
        int ones = ~0; // 11111111 11111111 11111111 11111111          
        
        int leftShiftJ = ones << (j + 1); 
        int leftShiftI = ((1 << i) - 1); 
        
        int mask = leftShiftJ | leftShiftI; 
        
        int applyMaskToQ = q & mask;                        
        int bringQInPlace = p << i;        

        return applyMaskToQ | bringQInPlace; 
    }
}
