package coding.challenge;

public class Sum {

    public int sumBits(int q, int p) {
        
        int xor;
        int and;
        int t;
        
        and = q & p;
        xor = q ^ p;

        while (and != 0) {
            
            and = and << 1;
            
            t = xor ^ and;
            and = and & xor;
            xor = t;
        }
        
       return xor;
    }
}
