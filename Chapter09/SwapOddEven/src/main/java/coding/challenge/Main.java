package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int number = 663;        

        int result = Bits.swap(number);
        
        System.out.println("Initial:\t\t" + Integer.toBinaryString(number));
        System.out.println("Swapped:\t\t" + Integer.toBinaryString(result));        
    }

}
