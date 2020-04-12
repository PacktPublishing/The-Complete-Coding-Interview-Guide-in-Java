package coding.challenge;

public class Main {

    public static void main(String[] args) {

        System.out.println("(2 equal 4) -> " + Bits.checkEquality(2, 4));
        System.out.println("(67 equal 66) -> " + Bits.checkEquality(67, 66));
        System.out.println("(0 equal 0) -> " + Bits.checkEquality(0, 0));
        System.out.println("(-2 equal -4) -> " + Bits.checkEquality(-2, -4));
        System.out.println("(-2 equal -2) -> " + Bits.checkEquality(-2, -2));
        System.out.println("(12 equal 12) -> " + Bits.checkEquality(12, 12));
    }

}
