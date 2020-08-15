package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int number = 423;
        int position = 6;

        int result1 = Bits.clearFromMsb(number, position);
        int result2 = Bits.clearFromPosition(number, position);

        System.out.println("Initial:\t\t\t\t" + Integer.toBinaryString(number));
        System.out.println("Result (clearFromMsb()):\t\t" + Integer.toBinaryString(result1));
        
        System.out.println("Initial:\t\t\t\t" + Integer.toBinaryString(number));
        System.out.println("Result (clearFromPosition()):\t\t" + Integer.toBinaryString(result2));
    }

}
