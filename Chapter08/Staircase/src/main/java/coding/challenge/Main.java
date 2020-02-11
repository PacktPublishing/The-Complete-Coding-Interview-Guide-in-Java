package coding.challenge;

public class Main {

    private static final int STEPS = 3;
    
    public static void main(String[] args) {        
        
        Staircase staircase = new Staircase();
        
        int count = staircase.count(STEPS);                
        System.out.println("Count: " + count);
        
        int countMemo = staircase.countViaMemoization(STEPS);
        System.out.println("Count via memo: " + countMemo);
    }

}
