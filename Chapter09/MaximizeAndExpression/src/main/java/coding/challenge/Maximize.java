package coding.challenge;

public class Maximize {

    private final static int MAX_INT_BIT = 32;

    int maximizeExpression(int p, int q) {

        int s = 0;

        int applyAnd = p & q;

        for (int i = 0; i < MAX_INT_BIT; i++) {

            // shift left i bits
            int shifted = 1 << i;

            // compute p & q & shifted
            int computed = applyAnd & shifted;

            // add the computation result to total
            s += computed;
        }
        
        return s;
    }
}
