package coding.challenge;

public class Sum {

    public int sumBits(int q, int p) {
        
        int copyQ = q;
        int copyP = p;
        
        int xor;
        int and;
        int t;
        
        and = copyQ & copyP;
        xor = copyQ ^ copyP;

        while (and != 0) {
            
            and = and << 1;
            
            t = xor ^ and;
            and = and & xor;
            xor = t;
        }
        
       return xor;
    }
}
