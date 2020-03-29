package coding.challenge;

public class Main {

    public static void main(String[] args) {

        /*
        1 2 3 2 1 1
        12 3 2 1 1 
        12 3 21 1
        12 3 2 11
        1 23 2 1 1
        1 23 21 1
        1 23 2 11
        1 2 3 11
        1 2 3 21 1
        */
        char digits[] = {'1', '2', '3', '2', '1', '1'};                
        
        System.out.println("Recursive approach: " + Digits.decoding(digits, digits.length));
        System.out.println("DP approach: " + Digits.decoding(digits));
    }
}
