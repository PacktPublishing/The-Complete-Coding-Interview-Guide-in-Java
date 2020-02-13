package coding.challenge;

public class Main {

    private static final int Q = 4914;
    private static final int P = 63;
  
    public static void main(String[] args) {

        Maximize maximize = new Maximize();

        int result = maximize.maximizeAndExpression(Q, P);
        System.out.println("Result: " + result + "(" + Integer.toString(result, 2) + ")");
    }

}
