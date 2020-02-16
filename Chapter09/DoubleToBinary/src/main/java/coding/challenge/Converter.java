package coding.challenge;

public class Converter {

    private static final int MAX_MANTISSA = 23;

    public String toBinary(float n) {
System.out.println(fractionalToBinary(n));
        return null;
    }

    private String sign(float n) {
        return n > 0 ? "1" : "0";
    }

    private String integralToBinary(float n) {
        double integralPart = Math.floor(n);

        return Integer.toBinaryString((int) integralPart);
    }

    private String fractionalToBinary(float n) {
      
        StringBuilder sb = new StringBuilder();        
        float fractionalPart = n - (float) Math.floor(n);
                
        int bitNr = 0;
        while (bitNr < MAX_MANTISSA) {
            
            fractionalPart = fractionalPart * 2.0f;
            
            if(fractionalPart >= 1.0f) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            
            if(fractionalPart == 1.0f) {
                break;
            }
            
            fractionalPart = fractionalPart - (float) Math.floor(fractionalPart);                                    
            bitNr ++;
        }
        
        return sb.toString();
    }
}
