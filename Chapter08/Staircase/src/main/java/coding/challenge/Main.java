package coding.challenge;

public class Main {

    public static void main(String[] args) {

        Staircase staircase = new Staircase();
        
        int count = staircase.count(10);                
        System.out.println("Count: " + count);
        
        int countMemo = staircase.countViaMemoization(10);
        System.out.println("Count via memo: " + countMemo);
    }

}
