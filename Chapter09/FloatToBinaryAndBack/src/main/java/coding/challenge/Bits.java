package coding.challenge;

public final class Bits {

    private static final int MANTISSA = 23;
    private static final int MANTISSA_MINUS_1 = 22;
    private static final int TWO_AT_22 = 4194304;         // 2 ^ 22 = 4194304
    private static final int TWO_AT_22_MINUS_1 = 4194303; // (2 ^ 22) - 1 = 4194303
    private static final int EXPONENT_BIAS = 127;
    private static final int MAX_EXPONENT = 255;
   
    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int toBinary(float n) {
        
        int minus = 0;                
        int fractionPart = 0;
        int exponent = EXPONENT_BIAS;               

        if (n < 0) {
            minus = Integer.MIN_VALUE;
            n = -n;
        }

        int integerPart = (int) Math.floor(n);
        n -= integerPart;

        for (int i = MANTISSA_MINUS_1; i >= 0; i--) {
            n += n;
            fractionPart += Math.floor(n) * Math.pow(2, i);
            n -= Math.floor(n);
        }

        while ((integerPart != 1) && (exponent > 0) && (exponent < MAX_EXPONENT)) {
            
            if (integerPart > 1) {
            
                int d = (integerPart & 1) << MANTISSA_MINUS_1;
                int e = fractionPart >> 1;

                fractionPart = d + e;
                integerPart = integerPart >> 1;

                exponent++;
            } else {
                
                integerPart = (fractionPart & TWO_AT_22) >> MANTISSA_MINUS_1;
                fractionPart = (fractionPart & TWO_AT_22_MINUS_1) << 1;

                n += n;

                fractionPart += Math.floor(n);
                n -= Math.floor(n);

                exponent--;
            }
        }

        int exponentInPlace = exponent << (MANTISSA_MINUS_1 + 1);        

        int result =  minus + exponentInPlace + fractionPart;
        
        return result;
    }

    public static float toFloat(int value) {

        int minus = -1;
        int exponent = 0;
        
        float fractionPart;        

        if ((value & Integer.MIN_VALUE) == 0) {
            minus = 1;
        }
        
        // 0x7F800000 = 1111111100000000000000000000000
        // 0x7FFFFF   = 0000000011111111111111111111111
        // 0x800000   = 0000000100000000000000000000000
        exponent = ((value & 0x7F800000) >> MANTISSA) - EXPONENT_BIAS;
        fractionPart = (value & 0x7FFFFF) + 0x800000;
        fractionPart = fractionPart / 0x800000;
        
        float result = minus * fractionPart * (float) Math.pow(2, exponent);

        return result;
    }
}
