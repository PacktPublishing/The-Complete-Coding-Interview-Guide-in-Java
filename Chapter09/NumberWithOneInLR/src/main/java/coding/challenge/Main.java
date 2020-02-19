package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int left = 3;
        int right = 7;

        int result = Bits.setBetween(left, right);
        System.out.println("Result: " + result
                + "(" + Integer.toBinaryString(result) + ")");
    }

}
