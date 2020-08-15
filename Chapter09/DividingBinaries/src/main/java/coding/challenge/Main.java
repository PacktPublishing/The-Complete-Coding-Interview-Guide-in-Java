package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int q = 23;
        int p = 7;

        long result1 = Bits.divideWithRemainder(q, p);        
        System.out.println(q + "(" + Long.toBinaryString(q) + ")" + " / "
                + p + "(" + Long.toBinaryString(p) + ")" + " = " + result1
                + "(" + Long.toBinaryString(result1) + ")");
        
        System.out.println("-------------------------------------------------");
        
        long result2 = Bits.divideWithoutRemainder(q, p);
        System.out.println(q + "(" + Long.toBinaryString(q) + ")" + " / "
                + p + "(" + Long.toBinaryString(p) + ")" + " = " + result2
                + "(" + Long.toBinaryString(result2) + ")");        
    }

}
