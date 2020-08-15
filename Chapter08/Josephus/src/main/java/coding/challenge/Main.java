package coding.challenge;
 
public class Main {

    public static void main(String[] args) {

        // 15 people, eliminating every 3th person until only one person is left
        // the survivor should be number 5        
        int n = 15;
        int k = 3;
     
        System.out.println("Using recursion! Survivor: " + Josephus.josephus(n, k) + "\n");

        Josephus.printJosephus(n, k);
    }

}
