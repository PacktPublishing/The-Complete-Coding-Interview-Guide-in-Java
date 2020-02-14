package coding.challenge;

public class Main {   

    public static void main(String[] args) {   
        
        Multiply multiply = new Multiply();
        
        int result = multiply.multiplyBits(23, 45);
        
        System.out.println("Result: " + result + "(" + Integer.toString(result, 2) + ")");
    }

}
