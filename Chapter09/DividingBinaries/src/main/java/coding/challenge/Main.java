package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int q = 11;
        int p = 2;

        long result = Bits.divide(q, p);

        System.out.println(q + "(" + Long.toBinaryString(q) + ")" + " / "
                + p + "(" + Long.toBinaryString(p) + ")" + " = " + result
                + "(" + Long.toBinaryString(result) + ")");

        System.out.println();
    }

}
