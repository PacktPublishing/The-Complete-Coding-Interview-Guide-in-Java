package coding.challenge;

public final class Bits {

    private static final int MANTISSA = 22;
    private static final String ZEROS_32 = "00000000000000000000000000000000";

    private Bits() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int toBinary(float value) {

        int i = 0;
        int minus = 0;
        int integer = 0;
        int exponent = 127;
        int fraction = 0;        
        int result = 0;

        if (value < 0) {
            minus = 0x80000000;
            value = -value;
        }

        integer = (int) Math.floor(value);
        value -= integer;
        
        for (i = MANTISSA; i >= 0; i--) {
            value += value;
            fraction += Math.floor(value) * Math.pow(2, i);
            value -= Math.floor(value);
        }
        
        while ((integer != 1) && (exponent > 0) && (exponent < 255)) {
            if (integer > 1) {
                int d = (integer & 1) << MANTISSA;
                int e = fraction >> 1;
                fraction = d + e;
                integer = integer >> 1;
                exponent++;
            } else {
                integer = (fraction & 0x400000) >> 22;
                fraction = (fraction & 0x3FFFFF) << 1;
                value += value;
                fraction += Math.floor(value);
                value -= Math.floor(value);
                exponent--;
            }
        }
        
        int f = exponent << (MANTISSA + 1);
        result = minus + f + fraction;
        
        return result;
    }

    public static double Binary32ToDouble(int value) {

        int minus = -1, exponent;
        double fraction, result;

        if ((value & Integer.MIN_VALUE) == 0) {
            minus = 1;
        }
        exponent = ((value & 0x7F800000) >> 23) - 127;
        fraction = value & 0x7FFFFF + 0x800000;
        fraction = fraction / 0x800000;
        result = minus * fraction * Math.pow(2, exponent);

        return (result);
    }
}
