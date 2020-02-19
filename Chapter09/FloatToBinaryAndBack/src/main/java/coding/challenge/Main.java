package coding.challenge;

public class Main {

    public static void main(String[] args) {

        float n = -404.0324f;

        int tobinary = Bits.toBinary(n);
        float tofloat = Bits.toFloat(tobinary);
        
        System.out.println("N:      " + n);
        System.out.println();
        
        System.out.println("Result: " + Integer.toBinaryString(tobinary));
        System.out.println("Test:   " + Integer.toBinaryString(Float.floatToRawIntBits(n)));

        System.out.println("Float:  " + tofloat);
    }

}
