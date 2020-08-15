package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int number = 124344;      
        
        int resultNext = Bits.next(number);
        int resultPrev = Bits.previous(number);

        System.out.println("Number:\t\t" + number + "\t" + Integer.toBinaryString(number));
        System.out.println("Next:\t\t" + resultNext + "\t" + Integer.toBinaryString(resultNext));
        System.out.println("Previous:\t" + resultPrev + "\t" + Integer.toBinaryString(resultPrev));
    }

}
