package coding.challenge;
 
public class Main {   

    public static void main(String[] args) {   
        
        int q = 124;
        int p = 29;

        int result = Bits.multiply(q, p);

        System.out.println(q + "(" + Integer.toBinaryString(q) + ")" + " * "
                + p + "(" + Integer.toBinaryString(p) + ")" + " = " + result
                + "(" + Integer.toBinaryString(result) + ")");
    }

}
