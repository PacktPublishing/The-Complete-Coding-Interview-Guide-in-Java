package coding.challenge;

public class Main {   

    public static void main(String[] args) {   
        
        Sum sum = new Sum();
        int result = sum.sumBits(23, 45);
        
        System.out.println("Result: " + result + "(" + Integer.toString(result, 2) + ")");
    }

}
