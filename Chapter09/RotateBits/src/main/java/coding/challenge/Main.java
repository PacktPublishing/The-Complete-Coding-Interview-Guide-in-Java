package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int number = 423099897;
        int bits = 10;

        int resultLeft = Bits.leftRotate(number, bits);
        int resultRight = Bits.rightRotate(number, bits);

        System.out.println("Initial:\t" + Integer.toBinaryString(number));
        System.out.println("Result-left:\t" + Integer.toBinaryString(resultLeft));
        
        System.out.println();

        System.out.println("Initial:\t" + Integer.toBinaryString(number));
        System.out.println("Result-right:\t" + Integer.toBinaryString(resultRight));
    }

}
