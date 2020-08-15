package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int n = 67;

        int result = Bits.sequence(n);

        System.out.println("A sequence of 101 is considered 111!");
        System.out.println("The longest sequence of 1 in "
                + Integer.toBinaryString(n) + " is equal to " + result);
    }

}
