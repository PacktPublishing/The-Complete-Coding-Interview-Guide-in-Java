package coding.challenge;

public class Converter {

    double Binary32ToDouble(int value)
{
  int minus = -1, exponent;
  double fraction, result;
 
  if((value & Integer.MIN_VALUE) == 0) {minus = 1;}
  exponent = ((value&0x7F800000)>>23) - 127;
  fraction = value&0x7FFFFF + 0x800000;
  fraction = fraction / 0x800000;
  result = minus * fraction * Math.pow(2, exponent);
  return(result);
}
    
    int DoubleToBinary32(double value) {
        int minus = 0, integer, exponent = 127, fraction = 0, i, result;

        if (value < 0) {
            minus = 0x80000000;          
            value = -value;
        }
        integer = (int) Math.floor(value);
        value -= integer;
        for (i = 22; i >= 0; i--) {
            value += value;
            fraction += Math.floor(value) * Math.pow(2, i);
            value -= Math.floor(value);
        }
        while ((integer != 1) && (exponent > 0) && (exponent < 255)) {
            if (integer > 1) {
                int d=(integer & 1) << 22;
                int e=fraction >> 1;
                fraction =  d+e ;
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
        int f=exponent << 23;
        result = minus + f + fraction;
        return (result);
    }

    private static final int MAX_MANTISSA = 23;
    private static final String ZEROS_32 = "00000000000000000000000000000000";

    public String toBinary(float n) {
        String sign = sign(n);
        String integralPart = integralToBinary(n);
        String fractionalPart = fractionalToBinary(n);
        /*
        int exponent = normalizing(integralPart);
        String finalIntegralPart = dropBitWhoseStateIsKnown(exponent, integralPart);
        // System.out.println("dee="+toBinary(exponent));
        String result = addRemainingZeros(sign + toBinary2(exponent)
                + finalIntegralPart + fractionalPart);
*/
        return integralPart+"."+fractionalPart;
    }

    private String sign(float n) {
        return n > 0 ? "0" : "1";
    }

    private String integralToBinary(float n) {
        double integralPart = Math.floor(Math.abs(n));

        return toBinary((int) integralPart);
    }

    private String fractionalToBinary(float n) {

        StringBuilder sb = new StringBuilder();
        float fractionalPart = Math.abs(n) - (float) Math.floor(Math.abs(n));

        int bitNr = 0;
        while (bitNr < MAX_MANTISSA) {

            fractionalPart = fractionalPart * 2.0f;

            if (fractionalPart >= 1.0f) {
                sb.append("1");
            } else {
                sb.append("0");
            }

            if (fractionalPart == 1.0f) {
                break;
            }

            fractionalPart = fractionalPart - (float) Math.floor(fractionalPart);
            bitNr++;
        }

        return sb.toString();
    }

    public int normalizing(String integralToBinary) {

        int exponent = 0;
        int firstOneIndex = integralToBinary.indexOf("1");
        if (firstOneIndex != -1) {
            exponent = integralToBinary.length() - firstOneIndex - 1;
        } else {
            //exponent = exponent - 
        }
//System.out.println("eeee:" + exponent);

        exponent += 127;

        return exponent;
    }

    private String dropBitWhoseStateIsKnown(int exponent, String integralPart) {

        if (integralPart.startsWith("1")) {
            return integralPart.substring(1);
        }

        return integralPart;
    }

    private String addRemainingZeros(String source) {
//        System.out.println(source);
        String zeros = ZEROS_32.substring(source.length());
        return source.concat(zeros);
        //return source;
    }

    private String toBinary(int source) {
        return Integer.toBinaryString(source);
    }

    private String toBinary2(int source) {
        String q = Integer.toBinaryString(source);

        int s = q.length() + 1 - 8;
        String x = "";
        for (int i = 0; i <= s; i++) {
            x = x + "0";
        }

        return x.concat(q);
    }
}
