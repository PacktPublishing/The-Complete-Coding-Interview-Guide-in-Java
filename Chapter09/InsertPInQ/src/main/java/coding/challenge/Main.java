package coding.challenge;

public class Main {

    private static final int Q = 4914;
    private static final int P = 63;
    private static final int I = 4;
    private static final int J = 9;
        
    public static void main(String[] args) {
     
        Insertion insertion = new Insertion();        
        
        System.out.println("Q (in Q we insert): " + Integer.toString(Q, 2) + "(" + Q + ")");
        System.out.println("P (what we insert): " + Integer.toString(P, 2) + "(" + P + ")");
        System.out.println();
        
        int result = insertion.updateBits(Q, P, I, J);
        
        System.out.println("Result: " + Integer.toString(result, 2));         
    }

}
