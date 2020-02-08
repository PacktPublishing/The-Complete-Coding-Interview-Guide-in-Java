package coding.challenge;

public class Main {

    public static void main(String[] args) {

        // 41 people, eliminating every 3th person until only one person is left
        // the survivor should be number 31
        
        Josephus josephus = new Josephus();
        System.out.println("Using recursion! Survivor: " + josephus.josephus(41, 3) + "\n");
       
       josephus.printJosephus(41, 3);
       
    }

}
