package coding.challenge;

public class Main {

    public static void main(String[] args) {

        int number = 423;
        int position = 7;

        char result = Bits.getValue(number, position);

        System.out.println("Bit at position " + position + " of binary "
                + Integer.toBinaryString(number) + " is: " + result);
    }

}
