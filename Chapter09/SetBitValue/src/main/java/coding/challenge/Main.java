package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        int number = 423;
        int position = 7;

        int result0 = Bits.setValueTo0(number, position);

        System.out.println("\nSetting bit on position " + position + " to 0:");
        System.out.println("Number: " + number + "(" + Integer.toBinaryString(number) + ")");
        System.out.println("Result: " + result0 + "(" + Integer.toBinaryString(result0) + ")");
        
        int result1 = Bits.setValueTo1(result0, position);

        System.out.println("\nSetting bit  on position " + position + " to 1:");
        System.out.println("Number: " + result0 + "(" + Integer.toBinaryString(result0) + ")");
        System.out.println("Result: " + result1 + "(" + Integer.toBinaryString(result1) + ")");
    }

}
