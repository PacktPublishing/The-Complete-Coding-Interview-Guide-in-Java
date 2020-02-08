package coding.challenge;

public class Main {

    public static void main(String[] args) {

        // 15 people, eliminating every 3th person until only one person is left
        // the survivor should be number 5        
        int n = 15;
        int k = 3;

        Josephus josephus = new Josephus();
        System.out.println("Using recursion! Survivor: " + josephus.josephus(n, k) + "\n");

        josephus.printJosephus(n, k);

    }

}
