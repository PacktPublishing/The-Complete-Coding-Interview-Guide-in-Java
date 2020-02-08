package coding.challenge;

public class Main {

    public static void main(String[] args) {

        Josephus josephus = new Josephus();
        System.out.println("Using recursion! Survivor: " + josephus.josephus(41, 3) + "\n");
       
       josephus.printJosephus(41, 3);
       
    }

}
